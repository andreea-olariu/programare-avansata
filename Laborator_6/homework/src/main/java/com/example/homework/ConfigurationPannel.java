package com.example.homework;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class ConfigurationPannel {
    private int nrOfDots;
    private double lineProbability;
    private DrawingArea drawingArea;

    public ConfigurationPannel(DrawingArea drawingArea) {
        this.drawingArea = drawingArea;
    }

    public Group getNewConfigurationPannel() {
        Text nrOfDotsText = new Text("Number of dots: ");
        Spinner<Integer> nrOfDotsField = new Spinner(0, 20, 0);


        Text lineProbilityText = new Text("Line probability: ");
        ChoiceBox<Double> lineProbabilityField = new ChoiceBox();
        lineProbabilityField.getItems().addAll(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0);


        Button createNewGame = new Button("Create new game");
        createNewGame.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            nrOfDots = nrOfDotsField.getValue();
            lineProbability = lineProbabilityField.getValue() != null ? lineProbabilityField.getValue() : 0;
            drawingArea.newGame();
            drawingArea.setNrOfDots(nrOfDots);
            drawingArea.setLineProbability(lineProbability);
            drawingArea.drawShapes();
        });

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgrey;");
        gridPane.setMinSize(820, 50);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(nrOfDotsText, 0, 0);
        gridPane.add(nrOfDotsField, 1, 0);
        gridPane.add(lineProbilityText, 2, 0);
        gridPane.add(lineProbabilityField, 3, 0);
        gridPane.add(createNewGame, 4, 0);

        Group group = new Group(gridPane);
        return group;
    }
}
