module com.example.compulsory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.compulsory to javafx.fxml;
    exports com.example.compulsory;
}