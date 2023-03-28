package com.example.compulsory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ControlPannel {
    public Group getControlPannel() {
        Button load = new Button("Load");
        Button save = new Button("Save");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgrey;");
        gridPane.setMinSize(820, 50);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);


        gridPane.add(load, 0, 0);
        gridPane.add(save, 1, 0);
        gridPane.add(reset, 2, 0);
        gridPane.add(exit, 3, 0);

        Group group = new Group(gridPane);
        return group;
    }
}
