import javax.swing.*;
import java.awt.*;

public class BankGui {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;

    private BankGui() {
        Ledger ledger = new Ledger();
        tabbedPane1.add(new BankMainPanel(ledger).getRootPanel());
        tabbedPane1.add(new BankStatsPanel().getRootPanel());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank");
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(new BankGui().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
