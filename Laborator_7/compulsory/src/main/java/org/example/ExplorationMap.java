package org.example;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private int dim;

    public ExplorationMap() {
        dim = 3;
        matrix = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    public ExplorationMap(int n) {
        this.dim = n;
        matrix = new Cell[n][n];
    }

    public synchronized boolean visit(int row, int col, Robot robot, Exploration explore) {
        if (!matrix[row][col].isVisited()) {
            System.out.println(robot + " visited row " + row + " column " + col);
            matrix[row][col].setVisited(true);
            List<Token> tokens = explore.getMemory().extractTokens(dim);
            matrix[row][col].setContent(tokens);
            return true;
        }

        return false;
    }


    public Cell[][] getMatrix() {
        return matrix;
    }

    public int getDim() {
        return dim;
    }

    public boolean isFull() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (!matrix[i][j].isVisited())
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Exploration map: \n");
        for (var row : matrix) {
            for (var cell : row) {
                result.append(cell);
            }
        }
        return result.toString();
    }
}