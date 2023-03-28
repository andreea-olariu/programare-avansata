package com.example.compulsory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ConfigurationPannel configPannel = new ConfigurationPannel();
        ControlPannel controlPannel = new ControlPannel();
        CanvaSpace canvaSpace = new CanvaSpace();

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(820, 540);

        gridPane.add(configPannel.getConfigurationPannel(), 0, 0);
        gridPane.add(canvaSpace.getCanvas(), 0, 1);
        gridPane.add(controlPannel.getControlPannel(), 0, 2);

        Group root = new Group(gridPane);

        Scene scene = new Scene(root, 820, 540);
        stage.setTitle("My drawing app");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}