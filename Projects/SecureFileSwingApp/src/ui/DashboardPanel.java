
package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.*;
import java.util.*;
import model.*;
import service.FileService;
import repo.FileRepo;
import repo.UserRepo;
import repo.NotificationRepo;
import repo.ActivityRepo;

public class DashboardPanel extends JPanel {
    private User user;
    private Runnable onLogout;
    private FileService files = new FileService();

    private DefaultTableModel myFilesModel = new DefaultTableModel(new Object[]{"ID","Name","Size (bytes)"}, 0);
    private JTable myFilesTable = new JTable(myFilesModel);

    private DefaultTableModel sharedInModel = new DefaultTableModel(new Object[]{"From","File Name","File ID"}, 0);
    private JTable sharedInTable = new JTable(sharedInModel);

    private DefaultTableModel notifModel = new DefaultTableModel(new Object[]{"Message","Read"}, 0);
    private JTable notifTable = new JTable(notifModel);

    private DefaultTableModel actModel = new DefaultTableModel(new Object[]{"Action","Time"}, 0);
    private JTable actTable = new JTable(actModel);

    public DashboardPanel(User user, Runnable onLogout){
        this.user = user;
        this.onLogout = onLogout;
        setLayout(new BorderLayout());

        // Top Bar
        JPanel top = new JPanel(new BorderLayout());
        JLabel who = new JLabel("Logged in as: " + user.getUsername() + " (" + user.getRole() + ")");
        JButton logout = new JButton("Logout");
        top.add(who, BorderLayout.WEST);
        top.add(logout, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // Tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("My Files", myFilesPanel());
        tabs.add("Shared With Me", sharedWithMePanel());
        tabs.add("Notifications", notificationsPanel());
        tabs.add("Activity Log", activityPanel());
        if("ADMIN".equalsIgnoreCase(user.getRole())){
            tabs.add("Users", usersPanel());
        }
        add(tabs, BorderLayout.CENTER);

        logout.addActionListener(e -> onLogout.run());
        refreshAll();
    }

    private JPanel myFilesPanel(){
        JPanel p = new JPanel(new BorderLayout());
        JPanel actions = new JPanel();
        JButton upload = new JButton("Upload File");
        JButton share = new JButton("Share Selected");
        actions.add(upload);
        actions.add(share);
        p.add(actions, BorderLayout.NORTH);
        p.add(new JScrollPane(myFilesTable), BorderLayout.CENTER);

        upload.addActionListener(e -> {
            JFileChooser ch = new JFileChooser();
            int r = ch.showOpenDialog(this);
            if(r == JFileChooser.APPROVE_OPTION){
                File f = ch.getSelectedFile();
                try{
                    files.upload(user.getId(), f);
                    refreshFiles();
                    JOptionPane.showMessageDialog(this, "Uploaded: " + f.getName());
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Upload failed: " + ex.getMessage());
                }
            }
        });
        share.addActionListener(e -> {
            int row = myFilesTable.getSelectedRow();
            if(row<0){ JOptionPane.showMessageDialog(this, "Select a file"); return; }
            String fileId = (String) myFilesModel.getValueAt(row, 0);
            String toUser = JOptionPane.showInputDialog(this, "Share with username:");
            if(toUser==null || toUser.isBlank()) return;
            boolean ok = files.share(user.getId(), toUser.trim(), fileId);
            if(ok) JOptionPane.showMessageDialog(this, "Shared successfully");
            else JOptionPane.showMessageDialog(this, "Share failed. Check username.", "Error", JOptionPane.ERROR_MESSAGE);
            refreshAll();
        });
        return p;
    }

    private JPanel sharedWithMePanel(){
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(sharedInTable), BorderLayout.CENTER);
        JButton download = new JButton("Download Selected");
        p.add(download, BorderLayout.SOUTH);

        download.addActionListener(e -> {
            int row = sharedInTable.getSelectedRow();
            if(row<0){ JOptionPane.showMessageDialog(this, "Select a shared file"); return; }
            String fileId = (String) sharedInModel.getValueAt(row, 2);
            repo.FileRepo.findById(fileId).ifPresentOrElse(file -> {
                JFileChooser ch = new JFileChooser();
                ch.setSelectedFile(new java.io.File(file.getOriginalName()));
                int r = ch.showSaveDialog(this);
                if(r == JFileChooser.APPROVE_OPTION){
                    try{
                        java.nio.file.Files.copy(java.nio.file.Paths.get(file.getStoredPath()), ch.getSelectedFile().toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(this, "Saved!");
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(this, "Download failed: " + ex.getMessage());
                    }
                }
            }, () -> JOptionPane.showMessageDialog(this, "File not found"));
        });

        return p;
    }

    private JPanel notificationsPanel(){
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(notifTable), BorderLayout.CENTER);
        JPanel actions = new JPanel();
        JButton mark = new JButton("Mark Read");
        JButton del = new JButton("Delete");
        actions.add(mark); actions.add(del);
        p.add(actions, BorderLayout.SOUTH);

        mark.addActionListener(e -> {
            int row = notifTable.getSelectedRow();
            if(row<0) return;
            String msg = (String) notifModel.getValueAt(row, 0);
            var list = repo.NotificationRepo.listForUser(user.getId());
            list.stream().filter(n -> n.getMessage().equals(msg)).findFirst().ifPresent(n -> {
                repo.NotificationRepo.markRead(n.getId());
                refreshNotifications();
            });
        });
        del.addActionListener(e -> {
            int row = notifTable.getSelectedRow();
            if(row<0) return;
            String msg = (String) notifModel.getValueAt(row, 0);
            var list = repo.NotificationRepo.listForUser(user.getId());
            list.stream().filter(n -> n.getMessage().equals(msg)).findFirst().ifPresent(n -> {
                repo.NotificationRepo.delete(n.getId());
                refreshNotifications();
            });
        });

        return p;
    }

    private JPanel activityPanel(){
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(actTable), BorderLayout.CENTER);
        return p;
    }

    private JPanel usersPanel(){
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"Username","Role"};
        DefaultTableModel userModel = new DefaultTableModel(cols, 0);
        JTable table = new JTable(userModel);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        JButton addUser = new JButton("Add User");
        p.add(addUser, BorderLayout.SOUTH);

        addUser.addActionListener(e -> {
            JTextField u = new JTextField();
            JTextField ptxt = new JTextField();
            String[] roles = {"USER","ADMIN"};
            JComboBox<String> role = new JComboBox<>(roles);

            JPanel form = new JPanel(new GridLayout(0,1));
            form.add(new JLabel("Username:")); form.add(u);
            form.add(new JLabel("Password:")); form.add(ptxt);
            form.add(new JLabel("Role:")); form.add(role);

            int r = JOptionPane.showConfirmDialog(this, form, "Add User", JOptionPane.OK_CANCEL_OPTION);
            if(r==JOptionPane.OK_OPTION){
                if(u.getText().isBlank() || ptxt.getText().isBlank()){
                    JOptionPane.showMessageDialog(this, "Provide username/password");
                    return;
                }
                if(repo.UserRepo.findByUsername(u.getText()).isPresent()){
                    JOptionPane.showMessageDialog(this, "Username exists");
                    return;
                }
                model.User nu = new model.User(u.getText(), ptxt.getText(), (String) role.getSelectedItem());
                repo.UserRepo.add(nu);
                refreshUsers(userModel);
            }
        });

        refreshUsers(userModel);
        return p;
    }

    private void refreshUsers(DefaultTableModel userModel){
        userModel.setRowCount(0);
        for(model.User u : repo.UserRepo.list()){
            userModel.addRow(new Object[]{u.getUsername(), u.getRole()});
        }
    }

    private void refreshFiles(){
        myFilesModel.setRowCount(0);
        for(FileItem f: files.myFiles(user.getId())){
            myFilesModel.addRow(new Object[]{f.getId(), f.getOriginalName(), f.getSize()});
        }
    }
    private void refreshSharedIn(){
        sharedInModel.setRowCount(0);
        for(Share s : files.incomingShares(user.getId())){
            var file = repo.FileRepo.findById(s.getFileId());
            var from = repo.UserRepo.findById(s.getFromUserId());
            String fileName = file.map(FileItem::getOriginalName).orElse("?");
            String fromName = from.map(User::getUsername).orElse("?");
            sharedInModel.addRow(new Object[]{fromName, fileName, s.getFileId()});
        }
    }
    private void refreshNotifications(){
        notifModel.setRowCount(0);
        for(Notification n: repo.NotificationRepo.listForUser(user.getId())){
            notifModel.addRow(new Object[]{n.getMessage(), n.isRead()});
        }
    }
    private void refreshActivities(){
        actModel.setRowCount(0);
        for(Activity a: repo.ActivityRepo.listForUser(user.getId())){
            actModel.addRow(new Object[]{a.getAction(), new java.util.Date(a.getTs()).toString()});
        }
    }

    private void refreshAll(){
        refreshFiles();
        refreshSharedIn();
        refreshNotifications();
        refreshActivities();
    }
}
