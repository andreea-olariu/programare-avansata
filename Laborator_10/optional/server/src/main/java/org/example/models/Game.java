package org.example.models;

public class Game {
    Board board;
    Player playerBlack = new Player("");
    Player playerWhite = new Player("");

    public Game(String player1, String player2) {
        // the size of a Gomoku board is 15
        board = new Board(15);
        playerBlack = new Player(player1);
        playerWhite = new Player(player2);
    }

    public Game() {
        // the size of a Gomoku board is 15
        board = new Board(15);
    }

    public synchronized String joinGame(String name) {
        if (playerBlack.getName().equals("")) {
            playerBlack = new Player(name);
            return "Joined the game as black";
        } else if (playerWhite.getName().equals("")) {
            playerWhite = new Player(name);
            return "Joined the game as white";

        }
        return "Game is full";
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public synchronized String submitMove(int r, int c, String color) {
        if (board.setTaken(r, c, color) == false) {
            return "Try again";
        }
        return "Move submited";
    }

    public synchronized String checkForWinner() {
        String winner = board.checkForWinner();
        return winner;
    }
}
