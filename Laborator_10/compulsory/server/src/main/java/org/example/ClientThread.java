package org.example;

// Clients are served in a concurrent manner, one by each thread

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String request = "";
        String response = "";
        try {
            // Get the request from the input stream: client to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send the response to the output stream: server to client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String command = "";

            StopServerThread stopServerThread = new StopServerThread(out);
            stopServerThread.start();

            do {
                // Read the content from the buffer
                request = in.readLine();
                System.out.println("The request is: " + request);

                response = "Server received the request!";
                    // Print the response to the buffer aka the client
                out.println(response);
                // Make sure it flushes from the buffer
                out.flush();
            } while (!request.equals("exit"));
            System.out.println("Client edisconnected!");
        } catch (IOException e) {
            System.err.println("Communication error between client and server... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("An error occurred when closing the server socket. Error is: " + ex.getMessage());
            }
        }

    }

}
