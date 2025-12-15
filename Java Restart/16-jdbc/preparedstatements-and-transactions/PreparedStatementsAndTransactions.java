// Demonstrates PreparedStatement and JDBC Transactions with banking example

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PREPAREDSTATEMENT & TRANSACTIONS (JDBC)
 * ---------------------------------------
 * PreparedStatement:
 *  - Precompiled SQL
 *  - Prevents SQL Injection
 *  - Better performance
 *
 * Transactions:
 *  - Group multiple SQL operations into a single unit
 *  - Either ALL succeed (commit) or ALL fail (rollback)
 *
 * Real-world use case:
 *  - Bank money transfer (debit + credit)
 *
 * Sample table:
 *
 * CREATE TABLE bank_accounts (
 *   account_no INT PRIMARY KEY,
 *   customer_name VARCHAR(50),
 *   balance DOUBLE
 * );
 */

public class PreparedStatementsAndTransactions {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/indian_app_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {

        System.out.println("=== JDBC PreparedStatement & Transactions Demo ===\n");

        // Example: Transfer ₹2000 from Rahul to Amit
        transferMoney(1001, 1002, 2000.00);

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- PreparedStatement prevents SQL Injection.");
        System.out.println("- Transactions ensure data consistency.");
        System.out.println("- commit() saves changes permanently.");
        System.out.println("- rollback() restores data on failure.");
        System.out.println("- Critical for banking and financial systems.");
    }

    /**
     * Transfers money between two accounts using JDBC transaction
     */
    static void transferMoney(int fromAccount, int toAccount, double amount) {

        String debitSQL =
                "UPDATE bank_accounts SET balance = balance - ? WHERE account_no = ?";
        String creditSQL =
                "UPDATE bank_accounts SET balance = balance + ? WHERE account_no = ?";

        Connection con = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // ----------------------------------------------------
            // Disable auto-commit (start transaction)
            // ----------------------------------------------------
            con.setAutoCommit(false);
            System.out.println("Transaction started...");

            // Debit from sender
            try (PreparedStatement debitStmt = con.prepareStatement(debitSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();
                System.out.println("₹" + amount + " debited from account " + fromAccount);
            }

            // Credit to receiver
            try (PreparedStatement creditStmt = con.prepareStatement(creditSQL)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();
                System.out.println("₹" + amount + " credited to account " + toAccount);
            }

            // ----------------------------------------------------
            // Commit transaction
            // ----------------------------------------------------
            con.commit();
            System.out.println("Transaction committed successfully ✔");

        } catch (Exception e) {
            System.out.println("Transaction failed ❌");
            System.out.println("Reason: " + e.getMessage());

            // ----------------------------------------------------
            // Rollback transaction
            // ----------------------------------------------------
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction rolled back 🔁");
                }
            } catch (SQLException ex) {
                System.out.println("Rollback failed!");
            }

        } finally {
            // ----------------------------------------------------
            // Close connection
            // ----------------------------------------------------
            try {
                if (con != null) {
                    con.setAutoCommit(true); // reset
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection.");
            }
        }
    }
}
