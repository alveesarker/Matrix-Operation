module com.example.matrixoperation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.matrixoperation to javafx.fxml;
    exports com.example.matrixoperation;
}