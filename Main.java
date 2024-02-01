import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main  {
    public static void main(String[] args) throws IOException {
        // Create a simple HTTP server on port 8082
        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);

        // Set the context for handling requests
        server.createContext("/", new MyHandler());

        // Start the server
        server.start();
        System.out.println("Server started on port 8082");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            // Send "Hello, Docker!" as the response
            String response = "Iam able to learn";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
