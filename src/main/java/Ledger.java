import com.github.javafaker.Faker;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Ledger implements Serializable {
    private ArrayList<BankAccount> accounts;

    Ledger() {
        accounts = new ArrayList<>();

        Faker faker = new Faker();
        Random random = new Random();

        String firstName;
        String lastName;
        int balance;

        for (int i = 1; i <= 100; i++) {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            balance = random.nextInt(45000) + 5000;

            accounts.add(new BankAccount(firstName, lastName, i, balance));
        }
    }

    public void addCustomer(String firstName, String lastName, int number, int balance) {
        accounts.add(new BankAccount(firstName, lastName, number, balance));
    }

    public void addCustomer(String firstName, String lastName, int number) {
        accounts.add(new BankAccount(firstName, lastName, number));
    }

    public void totalBalance() {
        int total = 0;
        for (BankAccount b : accounts) {
            total += b.getBalance();
        }
    }

    public void deleteCustomer(String firstName, String lastName) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getFirstName().equals(firstName) && accounts.get(i).getFirstName().equals(lastName)) {
                accounts.remove(i);
                break;
            }
        }
    }

    public void findCustomer(String lastName) {
        for (BankAccount b : accounts) {
            if (b.getLastName().equals(lastName)) {
                System.out.println(b);
            }
        }
    }

    public void findCustomer(String firstName, String lastName) {
        for (BankAccount b : accounts) {
            if (b.getFirstName().equals(firstName) && b.getLastName().equals(lastName)) {
                System.out.println(b);
            }
        }
    }

    void saveLedger() throws IOException {
        FileOutputStream file = new FileOutputStream("bankdata.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);

        for (BankAccount b : accounts) {
            out.writeObject(b);
        }
        out.close();
        file.close();
    }

    private void loadLedger() {
        try {
            FileInputStream file = new FileInputStream("bankdata.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            accounts = new ArrayList<>();

            accounts.add((BankAccount) in.readObject());

            in.close();
            file.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BankAccount b : accounts) {
            stringBuilder.append(b.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}
