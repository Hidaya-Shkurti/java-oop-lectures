/*
 * Week 2 - Your first class
 *
 * Every word the user reads is written here.
 */
public class BankApp {

    public static void main(String[] args) {
        Account ada = new Account("AC-1001", "Ada Lovelace", 500.00);
        System.out.println(ada);

        System.out.println();
        if (ada.withdraw(200.00)) {
            System.out.println("Withdrawal accepted.");
        } else {
            System.out.println("Not enough money.");
        }

        if (ada.withdraw(900.00)) {
            System.out.println("Withdrawal accepted.");
        } else {
            System.out.println("Not enough money.");
        }

        System.out.println(ada);

        // Three separate accounts, each with its own state.
        System.out.println();
        Account alan  = new Account("AC-1002", "Alan Turing", 2500.00);
        Account grace = new Account("AC-1003", "Grace Hopper", 1500.00);

        alan.withdraw(100.00);

        System.out.println(ada);
        System.out.println(alan);
        System.out.println(grace);

        // Nothing validates yet. Every one of these is accepted.
        System.out.println();
        System.out.println("What this class still lets through:");
        System.out.println("  " + new Account("AC-1004", null, -5000.00));
        System.out.println("  " + new Account("", "", 0.00));
        System.out.println("Week 3 fixes that.");
    }
}