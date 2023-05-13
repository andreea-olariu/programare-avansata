package org.example.models;

public class Board {
    String[][] gameBoard;
    int dim;

    public Board(int d) {
        dim = d;
        gameBoard = new String[dim - 1][dim - 1];
        for(int i = 0; i < dim - 1; i++) {
            for(int j = 0; j < dim - 1; j++)
                gameBoard[i][j] = "";
        }
    }

    public boolean setTaken(int r, int c, String color) {
        if (r < dim - 1 && c < dim - 1 && r >= 0 && c >= 0) {
            gameBoard[r - 1][c - 1] = color;
            return true;
        }
        return false;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public String checkForWinner() {
        for (int i = 0; i < dim - 1; i++) {
            for (int j = 0; j < dim - 6; j++) {
                if (!gameBoard[i][j].equals("")
                        && gameBoard[i][j].equals(gameBoard[i][j + 1])
                        && gameBoard[i][j].equals(gameBoard[i][j + 2])
                        && gameBoard[i][j].equals(gameBoard[i][j + 3])
                        && gameBoard[i][j].equals(gameBoard[i][j + 4])
                        && gameBoard[i][j].equals(gameBoard[i][j + 5]))
                    return gameBoard[i][j];

                if (!gameBoard[j][i].equals("")
                        && gameBoard[j][i].equals(gameBoard[j + 1][i])
                        && gameBoard[j][i].equals(gameBoard[j + 2][i])
                        && gameBoard[j][i].equals(gameBoard[j + 3][i])
                        && gameBoard[j][i].equals(gameBoard[j + 4][i])
                        && gameBoard[j][i].equals(gameBoard[j + 5][i]))
                    return gameBoard[j][i];
            }
        }
        return "";
    }
}
