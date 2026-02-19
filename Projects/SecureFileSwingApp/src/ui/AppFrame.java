
package ui;
import javax.swing.*;
import java.awt.*;
import model.User;

public class AppFrame extends JFrame {
    private CardLayout card = new CardLayout();
    private JPanel root = new JPanel(card);
    private LoginPanel loginPanel;
    private DashboardPanel dashboard;

    public AppFrame(){
        super("Secure File Access & Sharing — Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        loginPanel = new LoginPanel(this::onLoginSuccess, this::onSignupSuccess);
        root.add(loginPanel, "login");
        add(root);
    }

    private void onLoginSuccess(User u){
        dashboard = new DashboardPanel(u, this::logout);
        root.add(dashboard, "dash");
        card.show(root, "dash");
    }
    private void onSignupSuccess(){
        JOptionPane.showMessageDialog(this, "Signup successful. Please login.");
    }
    private void logout(){
        card.show(root, "login");
    }
}
