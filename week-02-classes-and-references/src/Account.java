/*
 * Week 2 - Your first class
 *
 * Fields, one constructor, methods, toString.
 *
 * Nothing is validated. The constructor will accept a negative balance and a
 * null owner, and that is deliberate: week 3 closes those holes. Write the
 * class first, feel where it leaks, then fix it.
 */
public class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Three getters and no setters. There is no setBalance, because setting a
    // balance to whatever you like is exactly the power private took away.
    // The balance moves through deposit and withdraw, or it does not move.

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // Nothing here prints. These methods report what happened and let the
    // caller decide what to say about it. A method that prints cannot be
    // tested (week 10) and cannot be used by a program with a window (week 13).

    @Override
    public String toString() {
        return String.format("Account %s (%s): %.2f EUR",
                accountNumber, ownerName, balance);
    }
}