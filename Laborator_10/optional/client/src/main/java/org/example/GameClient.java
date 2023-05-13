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
            String clientColor = "";
            do {
                String response = in.readLine();
                System.out.println(response);
                request = scanner.nextLine();
                out.println(request);
                out.flush();

                response = in.readLine();
                System.out.println(response);
                String input;

                switch (response) {
                    case "Enter a name: ":
                        input = scanner.nextLine();
                        out.println(input);
                        out.flush();

                        response = in.readLine();
                        System.out.println(response);
                        if(response.contains("white")) {
                            clientColor = "white";
                        } else {
                            clientColor = "black";
                        }
                        break;
                    case "Enter a row between 1 and 14: ":
                        input = scanner.nextLine();
                        out.println(input);
                        out.flush();
                        response = in.readLine();
                        System.out.println(response);

                        input = scanner.nextLine();
                        out.println(input);
                        out.flush();

                        out.println(clientColor);
                        out.flush();
                        response = in.readLine();
                        System.out.println(response);

                    default:
                        break;
                }
            } while (!request.equals("exit"));
            System.out.println("Disconnecting...");
            System.exit(0);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
