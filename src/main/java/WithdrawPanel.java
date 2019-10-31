import javax.swing.*;
import java.awt.event.ActionListener;

public class WithdrawPanel {
    private JButton withdrawButton;
    private JSpinner withdrawValueSpinner;
    private JPanel rootPanel;

    WithdrawPanel() {
        rootPanel.setName("Withdraw");

        ActionListener actionListener = e -> {
            if (e.getSource() == withdrawButton) {
                Withdraw();
            }
        };

        withdrawButton.addActionListener(actionListener);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void Withdraw() {
        System.out.println();
    }
}
