/*
 * Week 2 - What a variable really holds
 *
 * Predict the output of each block on paper before you run it.
 * Running it first and nodding teaches nothing.
 */
public class ReferenceDemo {

    public static void main(String[] args) {

        // 1. Two names, one object.
        //    backup = ada copies the arrow, not the account.
        System.out.println("--- 1. Two names, one object");
        Account ada = new Account("AC-1001", "Ada Lovelace", 500.00);
        Account backup = ada;

        backup.withdraw(200.00);

        System.out.println("  ada.getBalance()    = " + ada.getBalance());
        System.out.println("  backup.getBalance() = " + backup.getBalance());

        // 2. Two objects that look alike.
        //    == compares arrows, never the contents behind them.
        System.out.println();
        System.out.println("--- 2. Two objects with identical values");
        Account twin = new Account("AC-1001", "Ada Lovelace", 300.00);

        System.out.println("  ada == backup : " + (ada == backup));
        System.out.println("  ada == twin   : " + (ada == twin));

        // Strings are objects too, so == on them compares arrows.
        // Java reuses identical literals, which is why this one often looks
        // like it works, right up until the text comes from a file.
        System.out.println();
        String a = new String("AC-1001");
        String b = new String("AC-1001");
        System.out.println("  a == b       : " + (a == b));
        System.out.println("  a.equals(b)  : " + a.equals(b));

        // 3. An arrow pointing nowhere.
        System.out.println();
        System.out.println("--- 3. null");
        Account closed = null;
        System.out.println("  closed == null : " + (closed == null));
        System.out.println("  Now asking a null for its balance:");
        try {
            System.out.println(closed.getBalance());
        } catch (NullPointerException e) {
            // Catching is week 9. It is here only so the rest of the file runs.
            System.out.println("  " + e.getMessage());
        }

        // 4. Handing an object to a method.
        //    Java copies the arrow. It does not copy the account.
        System.out.println();
        System.out.println("--- 4. Passing to a method");
        Account alan = new Account("AC-1002", "Alan Turing", 1000.00);

        System.out.println("  before applyFee : " + alan.getBalance());
        applyFee(alan);
        System.out.println("  after  applyFee : " + alan.getBalance());

        System.out.println("  before replace  : " + alan.getOwnerName());
        replace(alan);
        System.out.println("  after  replace  : " + alan.getOwnerName());
    }

    // Changes the object it was handed. The change survives.
    static void applyFee(Account account) {
        account.withdraw(5.00);
    }

    // Points its own parameter somewhere else. The caller's arrow never moves.
    static void replace(Account account) {
        account = new Account("AC-9999", "Nobody", 0.00);
    }
}