import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger
{
    private ArrayList<BankAccount> accounts;

    Ledger()
    {
        accounts = new ArrayList<>();
    }

    void allAccounts()
    {
        for (BankAccount b : accounts)
        {
            System.out.println(b);
        }
    }

    public void addCustomer(String firstName, String lastName, int number, int balance)
    {
        accounts.add(new BankAccount(firstName, lastName, number, balance));
    }

    public void addCustomer(String firstName, String lastName, int number)
    {
        accounts.add(new BankAccount(firstName, lastName, number));
    }

    public void totalBalance()
    {
        int total = 0;
        for (BankAccount b : accounts)
        {
            total += b.getBalance();
        }
    }

    public void deleteCustomer(String firstName, String lastName)
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getFirstName().equals(firstName) &&
                    accounts.get(i).getFirstName().equals(lastName))
            {
                accounts.remove(i);
                break;
            }
        }
    }

    void sortAccountsLastName()
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            for (int j = 0; j < accounts.size() - 1; j++)
            {
                if (accounts.get(j).getLastName().compareTo(accounts.get(j+1).getLastName()) > 0)
                {
                    BankAccount one = accounts.get(j);
                    BankAccount two = accounts.get(j+1);
                    accounts.set(j, two);
                    accounts.set(j+1, one);
                }
            }
        }
    }

    public void sortAccountsBalance()
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            for (int j = 0; j < accounts.size() - 1; j++)
            {
                if (accounts.get(j).getBalance() < accounts.get(j+1).getBalance())
                {
                    BankAccount one = accounts.get(j);
                    BankAccount two = accounts.get(j+1);
                    accounts.set(j, two);
                    accounts.set(j+1, one);
                }
            }
        }
    }

    public void sortAccountsNumber()
    {
        for (int i = 0; i < accounts.size(); i++)
        {
            for (int j = 0; j < accounts.size() - 1; j++)
            {
                if (accounts.get(j).getNumber() < accounts.get(j+1).getNumber())
                {
                    BankAccount one = accounts.get(j);
                    BankAccount two = accounts.get(j+1);
                    accounts.set(j, two);
                    accounts.set(j+1, one);
                }
            }
        }
    }

    public void findCustomer(String lastName)
    {
        for (BankAccount b : accounts)
        {
            if (b.getLastName().equals(lastName))
            {
                System.out.println(b);
            }
        }
    }

    public void findCustomer(String firstName, String lastName)
    {
        for (BankAccount b : accounts)
        {
            if (b.getFirstName().equals(firstName) && b.getLastName().equals(lastName))
            {
                System.out.println(b);
            }
        }
    }

    void saveLedger() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("BankData.txt"));
        for (BankAccount b : accounts)
        {
            writer.write(b.forFile());
            writer.newLine();
        }
        writer.close();
    }

    void loadLedger() throws FileNotFoundException
    {
        File file = new File("BankData.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            accounts.add(new BankAccount(scanner.nextLine()));
        }
    }
}
