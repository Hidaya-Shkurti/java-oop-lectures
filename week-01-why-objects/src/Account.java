public class Account {

    private double balance;

    public Account(double openingBalance) {
        this.balance = openingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}
