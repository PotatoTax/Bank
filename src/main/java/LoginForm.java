import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel rootPanel;

    private LoginForm() {
        rootPanel.setName("Login");
        ActionListener actionListener = actionEvent -> {
            if (actionEvent.getSource() == loginButton) {
                login();
            }
        };

        loginButton.addActionListener(actionListener);
    }

    private void login() {
        System.out.println("log");
        if (passwordField1.getText().equals(" ") || textField1.getText().equals(" ") || textField2.getText().equals(" ")) {
            System.out.println("Missing input");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank");
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(new LoginForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
