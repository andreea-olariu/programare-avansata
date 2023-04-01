package com.example.homework;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.io.*;

public class ControlPannel {

    private DrawingArea drawingArea;

    public ControlPannel(DrawingArea drawingArea) {
        this.drawingArea = drawingArea;
    }

    public Group getControlPannel() {
        Button load = new Button("Load");

        load.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            DrawingArea drawing = null;
            try {
                FileInputStream in = new FileInputStream("o.ser");
                ObjectInputStream s = new ObjectInputStream(in);
                drawing = (DrawingArea) s.readObject();
                in.close();
                s.close();
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("A problem occured at loading");
            }

            drawingArea = drawing;
            drawingArea.drawShapes();
        });

        Button export = new Button("Export as PNG");

        export.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            WritableImage writableImage = new WritableImage(820, 540);
            drawingArea.getAllDrawings().snapshot(null, writableImage);
            File file = new File("canva.png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            } catch (Exception s) {
                System.out.println("A problem occured at saving a picture of this game.");
            }

        });

        Button save = new Button("Save");

        save.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("o.ser"));
                oos.writeObject(drawingArea);
                oos.close();
            } catch (Exception e) {
                System.out.println("A problem occured at saving the status of this game.");
            }
        });

        Button reset = new Button("Reset");

        reset.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            drawingArea.newGame();
            drawingArea.drawShapes();
        });
        Button exit = new Button("Exit");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgrey;");
        gridPane.setMinSize(820, 50);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(export, 0, 0);
        gridPane.add(load, 1, 0);
        gridPane.add(save, 2, 0);
        gridPane.add(reset, 3, 0);
        gridPane.add(exit, 4, 0);

        return new Group(gridPane);
    }
}
