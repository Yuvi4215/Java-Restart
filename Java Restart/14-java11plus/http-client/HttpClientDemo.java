import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * JAVA 11+ HTTP CLIENT
 * ----------------------
 * HttpClient API supports:
 *  - Synchronous GET & POST requests
 *  - Asynchronous requests using CompletableFuture
 *  - Custom headers
 *  - JSON data handling
 *  - Timeouts and error handling
 *
 * Replaces old HttpURLConnection with modern, clean API.
 */

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== Java 11 HttpClient Demo ===\n");

        // ------------------------------------------------------------
        // 1. Creating HttpClient
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 1. Creating HttpClient *");

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        System.out.println("HttpClient Created.\n");


        // ------------------------------------------------------------
        // 2. Simple GET Request
        // ------------------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("* 2. Simple GET Request *");

        HttpRequest getReq = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();

        try {
            HttpResponse<String> getResp = client.send(getReq, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + getResp.statusCode());
            System.out.println("Response Body:\n" + getResp.body());
        } catch (HttpTimeoutException e) {
            System.out.println("GET Request Timed Out!");
        }


        // ------------------------------------------------------------
        // 3. POST Request with JSON Body
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. POST Request (JSON Body) *");

        String jsonData = """
                {
                    "title": "Java HttpClient",
                    "body": "Learning POST request",
                    "userId": 1
                }
                """;

        HttpRequest postReq = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();

        HttpResponse<String> postResp =
                client.send(postReq, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + postResp.statusCode());
        System.out.println("Response Body:\n" + postResp.body());


        // ------------------------------------------------------------
        // 4. ASYNC GET Request (Non Blocking)
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. Asynchronous GET Request *");

        HttpRequest asyncGetReq = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> future =
                client.sendAsync(asyncGetReq, HttpResponse.BodyHandlers.ofString());

        System.out.println("Request sent asynchronously...");
        
        future.thenAccept(response -> {
            System.out.println("\nAsync Status Code: " + response.statusCode());
            System.out.println("Async Response Body:\n" + response.body());
        }).join();  // Wait for async to finish


        // ------------------------------------------------------------
        // 5. Error Handling Example
        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Error Handling (Invalid URL) *");

        HttpRequest badReq = HttpRequest.newBuilder()
                .uri(URI.create("https://invalid.url.1234"))
                .GET()
                .build();

        try {
            client.send(badReq, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }


        // ------------------------------------------------------------
        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- Java 11 HttpClient simplifies HTTP operations.");
        System.out.println("- Supports GET, POST, and async requests.");
        System.out.println("- Works with JSON easily.");
        System.out.println("- Built-in timeout, headers, and URI builder.");
        System.out.println("- Replaces old HttpURLConnection completely.");
    }
}
