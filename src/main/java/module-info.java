module com.example.matrixoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.matrixoperation to javafx.fxml;
    exports com.example.matrixoperation;
}