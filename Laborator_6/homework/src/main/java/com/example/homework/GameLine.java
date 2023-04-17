package com.example.homework;

import javafx.scene.shape.Line;

import java.io.Serializable;

public class GameLine extends Line implements Serializable {
    private boolean colored;

    public GameLine() {
        colored = false;
    }

    public boolean commonDot(GameLine line) {
        if((line.getStartX() == this.getStartX() || line.getStartX() == this.getEndX() || line.getEndX() == this.getStartX() || line.getEndX() == this.getEndX())
            && (line.getStartY() == this.getStartY() || line.getStartY() == this.getEndY() || line.getEndY() == this.getStartY() || line.getEndY() == this.getEndY())) {
            return true;
        }
        return false;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }
}
