// Demonstrates how to connect Java application to a database using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC CONNECTION DEMO
 * ---------------------
 * JDBC (Java Database Connectivity) is an API used to connect
 * Java applications with relational databases.
 *
 * This demo covers:
 * 1. JDBC architecture overview
 * 2. Loading JDBC driver
 * 3. Creating database connection
 * 4. Handling connection errors
 * 5. Closing connection properly
 *
 * Database Used (example):
 * - MySQL
 *
 * NOTE:
 * - This file demonstrates connection logic only
 * - CRUD operations will be covered in separate files
 */

public class ConnectingToDB {

    // Database connection details
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/myappdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {

        System.out.println("=== JDBC Database Connection Demo ===\n");

        Connection connection = null;

        try {
            // ----------------------------------------------------
            // 1. Load JDBC Driver (Optional from JDBC 4.0+)
            // ----------------------------------------------------
            System.out.println("* Loading JDBC Driver *");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully.\n");

            // ----------------------------------------------------
            // 2. Establish Database Connection
            // ----------------------------------------------------
            System.out.println("* Connecting to Database *");

            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            System.out.println("Database connected successfully!");

            // ----------------------------------------------------
            // 3. Verify Connection
            // ----------------------------------------------------
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection is OPEN.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println("Reason: " + e.getMessage());

        } finally {
            // ----------------------------------------------------
            // 4. Close Connection
            // ----------------------------------------------------
            System.out.println("\n* Closing Database Connection *");

            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully.");
                }
            } catch (SQLException e) {
                System.out.println("Error while closing connection!");
            }
        }

        // ----------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- JDBC connects Java to relational databases.");
        System.out.println("- DriverManager manages JDBC drivers.");
        System.out.println("- Connection represents DB session.");
        System.out.println("- Always close DB resources.");
        System.out.println("- Use try-with-resources in real applications.");
    }
}
