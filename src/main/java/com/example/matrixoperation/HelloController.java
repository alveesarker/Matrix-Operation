package com.example.matrixoperation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Matrix m = new Matrix();
        m.setMatrix(2, 3);
        m.showMatrix();
    }
}