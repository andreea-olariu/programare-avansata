package com.example.homework;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.*;
import java.util.*;

import static java.lang.Math.min;

public class DrawingArea implements Serializable {
    transient private Canvas canvas;
    transient private GraphicsContext graphicsContext;
    transient private Pane overlay;
    private int nrOfDots;
    private double lineProbability;
    transient private Color color;
    private int player;
    private List<GameLine> blue;
    private List<GameLine> red;

    public DrawingArea() {
        nrOfDots = 0;
        lineProbability = 0.0;
        this.canvas = new Canvas(820, 440);
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.color = Color.GRAY;
        this.overlay = new Pane();
        this.player = 0;
        this.blue = new ArrayList<>();
        this.red = new ArrayList<>();
    }

    public void drawShapes() {
        if(canvas == null) {
            this.canvas  = new Canvas(820, 440);
        }
        if(graphicsContext == null) {
            this.graphicsContext = this.canvas.getGraphicsContext2D();
        }

        if(this.overlay == null) {
            this.overlay = new Pane();
        }

        double CANVAS_WIDTH = this.canvas.getWidth();
        double CANVAS_HEIGHT = this.canvas.getHeight();
        double alpha = 2 * Math.PI / nrOfDots;
        double circleRadius = min(CANVAS_WIDTH, CANVAS_HEIGHT) / 2;
        double[] X = new double[nrOfDots];
        double[] Y = new double[nrOfDots];

        double x0 = CANVAS_WIDTH / 2;
        double y0 = CANVAS_HEIGHT / 2;

        for(int i = 0; i < nrOfDots; i++) {
            X[i] = x0 + (circleRadius * Math.cos(alpha * i));
            Y[i] = y0 + (circleRadius * Math.sin(alpha * i));
            Circle circle = new Circle(X[i], Y[i], 15);
            overlay.getChildren().add(circle);
        }

        for(int i = 0; i < nrOfDots - 1; i++) {
            for (int j = i + 1; j < nrOfDots; j++) {
                GameLine line = new GameLine();
                line.setStrokeWidth(5);
                line.setStartX(X[i]);
                line.setStartY(Y[i]);
                line.setEndX(X[j]);
                line.setEndY(Y[j]);
                line.setOnMouseClicked(mouseEvent -> {
                    if(player % 2 == 0)
                        this.color = Color.RED;
                    else
                        this.color = Color.BLUE;
                    if(!line.isColored()) {
                        line.setFill(this.color);
                        line.setStroke(this.color);
                        line.setColored(true);

                        if(this.color == Color.BLUE) {
                            blue.add(line);
                        } else {
                            red.add(line);
                        }

                        player++;
                        String winner = GameLogic.showWinner(blue, red);
                        if(!winner.equals("Remiza")) {
                            Text text = new Text("Castigatorul este: " + winner);
                            this.newGame();
                            overlay.getChildren().add(text);
                            return;
                        }
                    }
                });
                overlay.getChildren().add(line);
            }
        }
    }

    public void newGame() {
        if(canvas == null) {
            this.canvas  = new Canvas(820, 440);
        }
        if(graphicsContext == null) {
            this.graphicsContext = this.canvas.getGraphicsContext2D();
        }

        if(this.overlay == null) {
            this.overlay = new Pane();
        }
        this.graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        this.overlay.getChildren().clear();
        this.blue.clear();
        this.red.clear();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public int getNrOfDots() {
        return nrOfDots;
    }

    public void setNrOfDots(int nrOfDots) {
        this.nrOfDots = nrOfDots;
    }

    public double getLineProbability() {
        return lineProbability;
    }

    public void setLineProbability(double lineProbability) {
        this.lineProbability = lineProbability;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Pane getOverlay() {
        return overlay;
    }

    public void setOverlay(Pane overlay) {
        this.overlay = overlay;
    }

    public Group getAllDrawings() {
        Group group = new Group(canvas, overlay);
        return group;
    }


}
