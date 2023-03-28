package com.example.compulsory;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvaSpace {
    public Group getCanvas() {
        Canvas canvas = new Canvas(820, 440);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        Group group = new Group(canvas);
        return group;
    }
}
