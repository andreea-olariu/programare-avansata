package org.example;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private int dim;

    public ExplorationMap() {
        this.dim = 100;
        matrix = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    public ExplorationMap(int n) {
        this.dim = n;
        matrix = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    public synchronized boolean visit(Robot robot, List<Token> tokens) {
        int row = -1;
        int col = -1;

        loop:
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (!matrix[i][j].isVisited()) {
                    row = i;
                    col = j;
                    break loop;
                }
            }
        }
        if(row == -1) {
            return false;
        }

        System.out.println(Thread.currentThread().getName() + ": " + robot + " visited row " + row + " column " + col);
        matrix[row][col].setVisited(true);
        matrix[row][col].setContent(tokens);
        return true;
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
        for (Cell[] row : matrix) {
            for (Cell cell : row) {
                result.append(cell);
            }
        }
        return result.toString();
    }
}