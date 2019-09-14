public class BankAccount {
    private String firstName;
    private String lastName;
    private int number;
    private int balance;

    public BankAccount(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        balance = 0;
    }

    public BankAccount(String firstName, String lastName, int number, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.balance = balance;
    }

    public BankAccount(String string) {
        String[] info = string.split("-");
        firstName = info[0];
        lastName = info[1];
        number = Integer.parseInt(info[2]);
        balance = Integer.parseInt(info[3]);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                ", balance=" + balance +
                '}';
    }

    public String forFile()
    {
        return firstName + "-" +
                lastName + "-" +
                number + "-" +
                balance;
    }
}
