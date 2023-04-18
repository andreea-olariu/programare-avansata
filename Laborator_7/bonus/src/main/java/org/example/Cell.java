package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int row;
    private int column;
    private List<Token> content;
    private boolean visited;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        content = new ArrayList<>();
        visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setContent(List<Token> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                ", content=" + content +
                ", visited=" + visited +
                "}\n";
    }
}
