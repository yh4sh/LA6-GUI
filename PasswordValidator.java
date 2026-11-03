import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class PasswordValidator {
    private JPanel mainPanel;
    private JPasswordField passwordTextField;
    private JLabel statusLabel;

    public PasswordValidator() {
        passwordTextField.setName("passwordTextField");
        statusLabel.setName("statusLabel");

        passwordTextField.setEchoChar('*');

        passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textValueChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textValueChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textValueChanged();
            }
        });
    }

    private void textValueChanged() {
        String password = new String(passwordTextField.getPassword());

        if (password.length() < 8) {
            showError("Password must be 8 characters long");
        } else if (!password.matches(".*\\d.*")) {
            showError("Password must contain at least one digit");
        } else if (!password.matches(".*[^A-Za-z0-9].*")) {
            showError("Password must contain at least one special character");
        } else {
            statusLabel.setForeground(new Color(0, 160, 0));
            statusLabel.setText("Password is valid");
        }
    }

    private void showError(String message) {
        statusLabel.setForeground(Color.RED);
        statusLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Password Validation");
            frame.setContentPane(new PasswordValidator().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 220);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
