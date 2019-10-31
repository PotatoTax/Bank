import javax.swing.*;
import java.awt.*;

public class ATMPanel {
    private JTabbedPane tabbedPane;
    private JPanel rootPanel;

    private ATMPanel() {
        tabbedPane.add(new DepositPanel().getRootPanel());
        tabbedPane.add(new WithdrawPanel().getRootPanel());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM");
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(new ATMPanel().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
