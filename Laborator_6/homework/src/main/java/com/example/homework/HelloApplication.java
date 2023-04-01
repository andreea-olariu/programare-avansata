package com.example.homework;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(820, 540);

        DrawingArea drawingArea = new DrawingArea();
        ConfigurationPannel configPannel = new ConfigurationPannel(drawingArea);
        gridPane.add(configPannel.getNewConfigurationPannel(), 0, 0);

        Group drawingGroup = new Group(drawingArea.getCanvas(), drawingArea.getOverlay());
        ControlPannel controlPannel = new ControlPannel(drawingArea);
        gridPane.add(drawingGroup, 0, 1);
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