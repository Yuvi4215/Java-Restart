/**
 * Encapsulation:
 * - Binding data (fields) and methods into one unit (class).
 * - Restricting direct access to internal data using private variables.
 * - Providing controlled access using public getter/setter methods.
 */
public class EncapsulationDemo {

    static class BankAccount {
        // Private fields (hidden from outside classes)
        private String accountHolder;
        private double balance;
        private String accountNumber;

        // Constructor
        BankAccount(String accountHolder, String accountNumber, double initialBalance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        // Public getter for account holder
        public String getAccountHolder() {
            return accountHolder;
        }

        // Public setter for account holder (with validation)
        public void setAccountHolder(String accountHolder) {
            if (accountHolder == null || accountHolder.isEmpty()) {
                System.out.println("Invalid account holder name!");
            } else {
                this.accountHolder = accountHolder;
            }
        }

        // Public getter for balance (read-only, no setter)
        public double getBalance() {
            return balance;
        }

        // Method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " successfully.");
            } else {
                System.out.println("Deposit amount must be positive!");
            }
        }

        // Method to withdraw money (controlled access)
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " successfully.");
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance!");
            }
        }

        // Public method to display basic account info (safe, hides details)
        public void displayInfo() {
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Account Number: " + maskAccountNumber(accountNumber));
            System.out.println("Current Balance: $" + balance);
        }

        // Private helper method (not accessible outside)
        private String maskAccountNumber(String number) {
            if (number.length() >= 4) {
                return "XXXX-XXXX-" + number.substring(number.length() - 4);
            } else {
                return "****";
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demo ===\n");

        System.out.println("------------------------------------");
        System.out.println("* 1. Creating a BankAccount object *");
        BankAccount acc1 = new BankAccount("Peter", "1234567890", 5000.00);
        acc1.displayInfo();
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 2. Accessing and Modifying Data Safely *");
        System.out.println("Current Holder: " + acc1.getAccountHolder());
        acc1.setAccountHolder("Peter Shinde");
        System.out.println("Updated Holder: " + acc1.getAccountHolder());
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 3. Performing Transactions *");
        acc1.deposit(1000);
        acc1.withdraw(1500);
        acc1.withdraw(7000); // invalid
        System.out.println("Final Balance: $" + acc1.getBalance());
        System.out.println();

        System.out.println("------------------------------------");
        System.out.println("* 4. Direct Access Restriction *");
        System.out.println("Note: Fields like balance and accountNumber are private,");
        System.out.println("so they cannot be accessed directly (uncommenting below lines causes error).");
        System.out.println(" acc1.balance = 99999:   Not allowed");
        System.out.println(" System.out.println(acc1.accountNumber):  Not allowed");
    }
}
