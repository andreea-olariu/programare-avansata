package org.example;

// A client makes requests to the server & receives responses

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

    private static String getCommand() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        return command;
    }

    public static void start() throws IOException {
        // The server's IP address = localhost
        String serverAddress = "127.0.0.1";
        // The server's port
        int PORT = 8000;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Send a request to the server
            String request;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter a command: ");
                request = scanner.nextLine();
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
            } while (!request.equals("exit"));
            System.out.println("Disconnecting...");
            System.exit(0);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
