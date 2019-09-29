import java.io.Serializable;

public class BankAccount implements Serializable {
    private String firstName;
    private String lastName;
    private int id;
    private int balance;

    BankAccount(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = number;
        balance = 0;
    }

    BankAccount(String firstName, String lastName, int number, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = number;
        this.balance = balance;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getId() {
        return id;
    }

    int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }
}
