// Demonstrates JDBC CRUD operations using Indian sample data

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC CRUD OPERATIONS (INDIAN CONTEXT)
 * -------------------------------------
 * Database: MySQL
 * Schema  : indian_app_db
 *
 * Sample table:
 *
 * CREATE TABLE customers (
 *   customer_id INT PRIMARY KEY AUTO_INCREMENT,
 *   name VARCHAR(50),
 *   email VARCHAR(100),
 *   city VARCHAR(50)
 * );
 */

public class CrudOperations {

    // Indian-style database configuration
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/indian_app_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {

        System.out.println("=== JDBC CRUD Operations (Indian Data) ===\n");

        insertCustomer("Rahul Sharma", "rahul.sharma@gmail.com", "Delhi");
        insertCustomer("Priya Verma", "priya.verma@gmail.com", "Mumbai");
        insertCustomer("Amit Patel", "amit.patel@gmail.com", "Ahmedabad");

        System.out.println("\n--- Reading Customers ---");
        readCustomers();

        System.out.println("\n--- Updating Customer City ---");
        updateCustomerCity(1, "Bengaluru");

        System.out.println("\n--- Reading Customers After Update ---");
        readCustomers();

        System.out.println("\n--- Deleting Customer ---");
        deleteCustomer(2);

        System.out.println("\n--- Reading Customers After Delete ---");
        readCustomers();

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- JDBC CRUD operations using PreparedStatement");
        System.out.println("- Realistic Indian customer data");
        System.out.println("- Safe from SQL Injection");
        System.out.println("- Industry-ready JDBC pattern");
    }

    // ----------------------------------------------------
    // CREATE (INSERT)
    // ----------------------------------------------------
    static void insertCustomer(String name, String email, String city) {

        String sql = "INSERT INTO customers(name, email, city) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, city);

            int rows = ps.executeUpdate();
            System.out.println("Inserted customer: " + name + " | Rows: " + rows);

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // ----------------------------------------------------
    // READ (SELECT)
    // ----------------------------------------------------
    static void readCustomers() {

        String sql = "SELECT customer_id, name, email, city FROM customers";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String city = rs.getString("city");

                System.out.println(id + " | " + name + " | " + email + " | " + city);
            }

        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }

    // ----------------------------------------------------
    // UPDATE
    // ----------------------------------------------------
    static void updateCustomerCity(int customerId, String newCity) {

        String sql = "UPDATE customers SET city = ? WHERE customer_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newCity);
            ps.setInt(2, customerId);

            int rows = ps.executeUpdate();
            System.out.println("Updated customer ID " + customerId +
                    " | New City: " + newCity +
                    " | Rows: " + rows);

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // ----------------------------------------------------
    // DELETE
    // ----------------------------------------------------
    static void deleteCustomer(int customerId) {

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            int rows = ps.executeUpdate();
            System.out.println("Deleted customer ID " + customerId + " | Rows: " + rows);

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}
