
package ui;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import service.AuthService;
import model.User;

public class LoginPanel extends JPanel {
    private AuthService auth = new AuthService();
    private Consumer<User> onLogin;
    private Runnable onSignupOK;

    public LoginPanel(Consumer<User> onLogin, Runnable onSignupOK){
        this.onLogin = onLogin;
        this.onSignupOK = onSignupOK;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8,8,8,8);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Secure File Access & Sharing");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));
        c.gridwidth = 2; c.gridx=0; c.gridy=0; add(title, c);
        c.gridwidth = 1;

        JLabel uLbl = new JLabel("Username");
        JTextField uTxt = new JTextField(20);
        JLabel pLbl = new JLabel("Password");
        JPasswordField pTxt = new JPasswordField(20);

        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Sign Up");

        c.gridx=0; c.gridy=1; add(uLbl, c);
        c.gridx=1; c.gridy=1; add(uTxt, c);
        c.gridx=0; c.gridy=2; add(pLbl, c);
        c.gridx=1; c.gridy=2; add(pTxt, c);
        c.gridx=0; c.gridy=3; add(loginBtn, c);
        c.gridx=1; c.gridy=3; add(signupBtn, c);

        loginBtn.addActionListener(e -> {
            String u = uTxt.getText().trim();
            String p = new String(pTxt.getPassword());
            auth.login(u,p).ifPresentOrElse(onLogin::accept, () -> {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            });
        });
        signupBtn.addActionListener(e -> {
            String u = uTxt.getText().trim();
            String p = new String(pTxt.getPassword());
            if(u.isEmpty() || p.isEmpty()){
                JOptionPane.showMessageDialog(this, "Enter username & password");
                return;
            }
            boolean ok = auth.signup(u,p);
            if(ok) onSignupOK.run();
            else JOptionPane.showMessageDialog(this, "Username already exists");
        });
    }
}
