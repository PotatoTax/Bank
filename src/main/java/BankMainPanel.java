import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankMainPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton refreshButton;
    private JTable accountsTable;
    private JFormattedTextField idField;
    JPanel rootPanel;

    private Ledger ledger;

    public BankMainPanel(Ledger ledger) {
        this.ledger = ledger;
        rootPanel.setName("Main");

        ActionListener actionListener = e -> {
            if (e.getSource() == refreshButton) {
                Refresh();
            }
        };

        refreshButton.addActionListener(actionListener);
    }

    private void Refresh() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        boolean idExists = true;
        int id = 0;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            idExists = false;
        }
        ArrayList<BankAccount> accounts = ledger.getAccounts();
        ArrayList<BankAccount> filtered = new ArrayList<>();

        if (!firstName.equals("")) {
            for (BankAccount b : accounts) {
                if (b.getFirstName().startsWith(firstName)) {
                    filtered.add(b);
                }
            }
        } else {
            filtered = accounts;
        }

        accounts = filtered;
        filtered = new ArrayList<>();

        if (!lastName.equals("")) {
            for (BankAccount b : accounts) {
                if (b.getLastName().startsWith(lastName)) {
                    filtered.add(b);
                }
            }
        } else {
            filtered = accounts;
        }

        accounts = filtered;
        filtered = new ArrayList<>();

        if (idExists) {
            for (BankAccount b : accounts) {
                if (id == b.getId()) {
                    filtered.add(b);
                }
            }
        } else {
            filtered = accounts;
        }

        String[] firstNames = new String[filtered.size()];
        String[] lastNames = new String[filtered.size()];
        String[] ids = new String[filtered.size()];
        String[] balances = new String[filtered.size()];

        for (int i = 0; i < filtered.size(); i++) {
            firstNames[i] = filtered.get(i).getFirstName();
            lastNames[i] = filtered.get(i).getLastName();
            ids[i] = Integer.toString(filtered.get(i).getId());
            balances[i] = Integer.toString(filtered.get(i).getBalance());
        }

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("First", firstNames);
        tableModel.addColumn("Last", lastNames);
        tableModel.addColumn("ID", ids);
        tableModel.addColumn("Balance", balances);

        accountsTable.setModel(tableModel);
    }
}
