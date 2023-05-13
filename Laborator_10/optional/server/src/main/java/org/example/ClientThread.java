package org.example;

// Clients are served in a concurrent manner, one by each thread

import org.example.models.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String request = "";
        String response = "";
        Game game = GameServer.game;
        long start = System.currentTimeMillis();
        long time = 1000;
        try {
            long current = System.currentTimeMillis();
            // Get the request from the input stream: client to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send the response to the output stream: server to client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String command = "";

            StopServerThread stopServerThread = new StopServerThread(out);
            stopServerThread.start();
            do {

                out.println("Enter a command: ");
                out.flush();
                // Read the content from the buffer
                request = in.readLine();
                System.out.println("The request is: " + request);

                switch (request) {
                    case "create game":
                        game = new Game();
                        response = "Game created";
                        out.println(response);
                        out.flush();
                        break;
                    case "join game":
                        out.println("Enter a name: ");
                        out.flush();
                        String name = in.readLine();
                        synchronized (game) {
                            response = game.joinGame(name);
                        }
                        out.println(response);
                        out.flush();
                        break;
                    case "submit move":
                        out.println("Enter a row between 1 and 14: ");
                        out.flush();
                        int row = parseInt(in.readLine());
                        out.println("Enter a column between 1 and 14: ");
                        out.flush();
                        int col = parseInt(in.readLine());

                        String color = in.readLine();

                        if ((color.equals("white") && game.getPlayerWhite() == null)
                                || (color.equals("black") && game.getPlayerBlack() == null)) {
                            response = "You haven't joined the game";
                        } else {
                            response = game.submitMove(row, col, color);
                        }

                        out.println(response);
                        out.flush();
                        break;
                    default:
                        break;
                }

                // check if somebody is winner
                String winner = game.checkForWinner();
                if (!winner.equals("")) {
                    out.println("Winner is: " + winner);
                    out.flush();
                    request = "exit";
                }

                current = System.currentTimeMillis();
                if (current - start > time) {
                    response = "Time passed. Game over";
                    out.println(response);
                    out.flush();
                    break;
                }
            }
            while (!request.equals("exit"));
            System.out.println("Client disconnected!");
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
