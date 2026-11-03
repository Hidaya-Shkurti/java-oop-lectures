public class BankApp {

    public static void main(String[] args) {
        Account ada = new Account(500.00);

        System.out.println("=== With an object ===");
        System.out.printf("  Balance: %.2f EUR%n", ada.getBalance());

        System.out.println();
        if (ada.withdraw(200.00)) {
            System.out.println("  Withdrawal of 200 accepted.");
        } else {
            System.out.println("  Withdrawal of 200 refused.");
        }
        System.out.printf("  Balance: %.2f EUR%n", ada.getBalance());

        System.out.println();
        if (ada.withdraw(900.00)) {
            System.out.println("  Withdrawal of 900 accepted.");
        } else {
            System.out.println("  Withdrawal of 900 refused. Not enough money.");
        }
        System.out.printf("  Balance: %.2f EUR%n", ada.getBalance());

        // The line that emptied Turing's account in TheOldWay does not even
        // compile here. Uncomment it and read what the compiler says.
        //
        // ada.balance -= 5000.00;

        System.out.println();
        System.out.println("  The balance is private, so the rule cannot be skipped.");
    }
}
