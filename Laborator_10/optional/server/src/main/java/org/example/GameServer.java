package org.example;

// Creating the server using TCP protocol in order to make sure all the moves are received correctly

import org.example.models.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8000;
    private static ServerSocket serverSocket = null;
    public static Game game;

    public GameServer() {
        // Creating an endpoint for communication
        try {
            serverSocket = new ServerSocket(PORT);
            game = new Game();

            // accepting the clients in an infinite loop until STOP command
            while (true) {
                // Client's socket
                Socket socket = serverSocket.accept();

                // Execute the client's request in a new thread
                // start -> triggers the method run() from the ClientThread
                new ClientThread(socket).start();
            }

        } catch (IOException e) {
            System.out.println("An error occurred when creating the server socket. Error is: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("An error occurred when closing the server socket. Error is: " + ex.getMessage());
                }
            }
        }
    }

}
