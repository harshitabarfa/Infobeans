
package app;
import ui.AppFrame;
import repo.DataBootstrap;

public class Main {
    public static void main(String[] args) {
        // Bootstrap data directories & default admin
        DataBootstrap.ensureBootstrap();
        javax.swing.SwingUtilities.invokeLater(() -> {
            new AppFrame().setVisible(true);
        });
    }
}
