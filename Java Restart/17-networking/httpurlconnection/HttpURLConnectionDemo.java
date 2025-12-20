// Demonstrates HTTP networking using HttpURLConnection (GET & POST)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HTTPURLCONNECTION DEMO
 * ----------------------
 * HttpURLConnection is a core Java API used to make HTTP requests
 * before Java 11 HttpClient was introduced.
 *
 * This file demonstrates:
 * 1. HTTP GET request
 * 2. HTTP POST request
 * 3. Reading response from server
 * 4. Setting request headers
 * 5. Handling response codes
 *
 * Commonly asked in interviews to test networking fundamentals.
 */

public class HttpURLConnectionDemo {

    public static void main(String[] args) {

        System.out.println("=== HttpURLConnection Demo ===\n");

        sendGetRequest();
        sendPostRequest();

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- HttpURLConnection is low-level HTTP API.");
        System.out.println("- Requires manual handling of streams.");
        System.out.println("- Replaced by HttpClient in Java 11+.");
        System.out.println("- Still important for interviews & legacy systems.");
    }

    // ------------------------------------------------------------
    // 1. HTTP GET Request
    // ------------------------------------------------------------
    static void sendGetRequest() {

        System.out.println("\n--- HTTP GET Request ---");

        try {
            // Public test API
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int statusCode = con.getResponseCode();
            System.out.println("Response Code: " + statusCode);

            BufferedReader reader;

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
            } else {
                reader = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
            }

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            con.disconnect();

            System.out.println("Response Body:");
            System.out.println(response);

        } catch (Exception e) {
            System.out.println("GET request failed: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // 2. HTTP POST Request
    // ------------------------------------------------------------
    static void sendPostRequest() {

        System.out.println("\n--- HTTP POST Request ---");

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // Enable output stream for POST
            con.setDoOutput(true);

            // Set headers
            con.setRequestProperty("Content-Type", "application/json");

            String jsonInput = """
                    {
                      "title": "Java Networking",
                      "body": "Learning HttpURLConnection",
                      "userId": 101
                    }
                    """;

            // Write request body
            try (OutputStream os = con.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }

            int statusCode = con.getResponseCode();
            System.out.println("Response Code: " + statusCode);

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(con.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            con.disconnect();

            System.out.println("Response Body:");
            System.out.println(response);

        } catch (Exception e) {
            System.out.println("POST request failed: " + e.getMessage());
        }
    }
}
// Java example 

