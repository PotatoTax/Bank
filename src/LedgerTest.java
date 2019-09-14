import java.io.IOException;

public class LedgerTest
{
    public static void main(String[] args) throws IOException
    {
        Ledger ledger = new Ledger();
/*
        ledger.addCustomer("a", "t", 1);
        ledger.addCustomer("a", "z", 1);
        ledger.addCustomer("a", "g", 1);
        */
        ledger.loadLedger();
        ledger.allAccounts();
        ledger.sortAccountsLastName();
        System.out.println();
        ledger.allAccounts();
        ledger.saveLedger();
    }
}
