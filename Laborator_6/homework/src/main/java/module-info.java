module com.example.homework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.homework to javafx.fxml;
    exports com.example.homework;
}