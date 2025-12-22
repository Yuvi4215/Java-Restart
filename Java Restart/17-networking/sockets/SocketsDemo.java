// Demonstrates basic Socket programming in Java (TCP Client-Server)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SOCKET PROGRAMMING IN JAVA
 * --------------------------
 * Socket programming enables communication between two machines
 * over a network using TCP/IP.
 *
 * Components:
 * - ServerSocket: Listens for client requests
 * - Socket: Used by client to connect to server
 *
 * This example demonstrates:
 * 1. TCP Server
 * 2. TCP Client
 * 3. Message exchange
 *
 * NOTE:
 * In real projects, Server and Client run in separate programs.
 * This file shows both for learning & GitHub documentation.
 */

public class SocketsDemo {

    public static void main(String[] args) {

        System.out.println("=== Java Socket Programming Demo ===\n");

        System.out.println("----------------------------------------");
        System.out.println("* 1. Server Code (Run separately) *");
        System.out.println(serverCode());

        System.out.println("----------------------------------------");
        System.out.println("* 2. Client Code (Run separately) *");
        System.out.println(clientCode());

        System.out.println("----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- ServerSocket waits for client connection.");
        System.out.println("- Socket enables data transfer.");
        System.out.println("- Uses TCP (reliable, ordered).");
        System.out.println("- Common in chat apps, banking systems, APIs.");
    }

    // ---------------- Simulated Code Blocks ---------------- //

    static String serverCode() {
        return """
        // File: BankServer.java

        import java.io.*;
        import java.net.*;

        public class BankServer {

            public static void main(String[] args) throws Exception {

                ServerSocket serverSocket = new ServerSocket(5000);
                System.out.println("Bank Server started on port 5000...");
                System.out.println("Waiting for client request...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader in =
                    new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                System.out.println("Received from client: " + clientMessage);

                // Indian banking-style response
                out.println("Transaction received. Processing in INR...");

                clientSocket.close();
                serverSocket.close();
            }
        }
        """;
    }

    static String clientCode() {
        return """
        // File: BankClient.java

        import java.io.*;
        import java.net.*;

        public class BankClient {

            public static void main(String[] args) throws Exception {

                Socket socket = new Socket("localhost", 5000);

                BufferedReader in =
                    new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

                // Sending Indian banking-style message
                out.println("Request to transfer ₹5000 from Rahul to Amit");

                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);

                socket.close();
            }
        }
        """;
    }
}
