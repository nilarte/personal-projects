package com.calsoft;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
 * Simple HTTP server that delegates to {@link ChaosDemoService} so that
 * chaosd can inject exceptions into the JVM. Requests to / trigger the
 * service call and the response is written back to the client.
 */
public class App {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", new ChaosHandler(new ChaosDemoService()));
        server.setExecutor(Executors.newFixedThreadPool(2));

        System.out.println("Starting HTTP server on port " + PORT);
        server.start();
    }

    private static class ChaosHandler implements HttpHandler {
        private final ChaosDemoService service;

        private ChaosHandler(ChaosDemoService service) {
            this.service = service;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            int statusCode = 200;
            try {
                response = service.processRequest();
            } catch (RuntimeException exception) {
                // Log the chaosd injected exception to the console and
                // return a 500 to the caller so that it is visible.
                System.err.println("Encountered exception in processRequest: " + exception);
                exception.printStackTrace(System.err);
                response = "Chaos exception encountered: " + exception.getMessage();
                statusCode = 500;
            }

            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }
    }
}
