package com.example.matrixoperation;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Arrays;

public class MatrixOperationController {
    @javafx.fxml.FXML
    private TextField matrixElementInput;
    @javafx.fxml.FXML
    private Text showMatrixText;
    @javafx.fxml.FXML
    private TextField onRowTwoInput;
    @javafx.fxml.FXML
    private TextField onRowOneInput;
    @javafx.fxml.FXML
    private TextField onColOneInput;
    @javafx.fxml.FXML
    private TextField onColTwoInput;
    @javafx.fxml.FXML
    private ComboBox<String> selectOperationComboBox;
    @javafx.fxml.FXML
    private CheckBox inputChoiceCheckbox;
    @javafx.fxml.FXML
    private Button generateRandomValueButton;
    @javafx.fxml.FXML
    private Button addElementToMatrixButton;

    Matrix m1, m2;
    int rowOne = 1;
    int colOne = 1;
    int rowTwo = 1;
    int colTwo = 1;
    @javafx.fxml.FXML
    private Text enterElementText;


    @javafx.fxml.FXML
    public void initialize() {
        generateRandomValueButton.setDisable(false);
        addElementToMatrixButton.setDisable(true);
        matrixElementInput.setDisable(true);
        selectOperationComboBox.getItems().addAll("Show Matrix", "Transpose Matrix", "Add Matrix");
        enterElementText.setText("Enter Matrix Elements M1("+ rowOne +"X" + colOne+")");
    }

    @javafx.fxml.FXML
    public void generateMatricesWithRandomValueOnAction(ActionEvent actionEvent) {
        m1 = new Matrix(
                Integer.parseInt(onRowOneInput.getText()),
                Integer.parseInt(onColOneInput.getText()),
                100
        );
        m2 = new Matrix(
                Integer.parseInt(onRowTwoInput.getText()),
                Integer.parseInt(onColTwoInput.getText()),
                100
        );
    }

    @javafx.fxml.FXML
    public void inputChoiceCheckboxOnAction(ActionEvent actionEvent) {
        if(inputChoiceCheckbox.isSelected()) {
            generateRandomValueButton.setDisable(true);
            addElementToMatrixButton.setDisable(false);
            matrixElementInput.setDisable(false);
            m1 = new Matrix();
            m2 = new Matrix();

        }else {
            generateRandomValueButton.setDisable(false);
            addElementToMatrixButton.setDisable(true);
            matrixElementInput.setDisable(true);
            m1 = null;
            m2 = null;
        }
    }

    @javafx.fxml.FXML
    public void ExecuteOperationOnAction(ActionEvent actionEvent) {
        if (m1 == null || m2 == null) {
            showMatrixText.setText("Click the button \"Generate Random\" first.");
        }
        if (selectOperationComboBox.getValue().equals("Show Matrix")){
            showMatrixText.setText("Matrix-1:\n" + m1.toString() + "\nMatrix-2:\n" + m2.toString());
//            System.out.println(("Matrix-1:\n" + m1.toString() + "\nMatrix-2:\n" + m2.toString()));
        } else if(selectOperationComboBox.getValue().equals("Add Matrix")) {
            Matrix resultMatrix = m1.addMatrices(m2);
            if (resultMatrix != null){
                showMatrixText.setText("Matrix-1:\n" + m1.toString() + "\nMatrix-2:\n" + m2.toString() + "\nSum of Matrix: \n" + resultMatrix.toString());
        } else {
                showMatrixText.setText("Both matrices must have the same number of rows and columns.");
            }
        }
    }

    @javafx.fxml.FXML
    public void addMatrixElementOnButton(ActionEvent actionEvent) {
        int value = Integer.parseInt(matrixElementInput.getText());
        if (m1.values == null){
            m1.values = new int[Integer.parseInt(onRowOneInput.getText())][Integer.parseInt(onColOneInput.getText())];
            m2.values = new int[Integer.parseInt(onRowTwoInput.getText())][Integer.parseInt(onColTwoInput.getText())];
            m1.values[rowOne - 1][colOne - 1] = value;
            colOne += 1;
        } else {
            if (rowOne <= Integer.parseInt(onRowOneInput.getText())) {

                if (colOne <= Integer.parseInt(onColOneInput.getText())) {
                    m1.values[rowOne- 1][colOne-1] = value;
                    colOne += 1;
                    if (rowOne == Integer.parseInt(onRowOneInput.getText())){
                        rowOne += 1;
                    }
                }else {
                    rowOne += 1;
                    colOne = 1;
                    m1.values[rowOne- 1][colOne-1] = value;
                    colOne += 1;
                }
            } else {
                if (colTwo <= Integer.parseInt(onColTwoInput.getText())) {
                    m2.values[rowTwo- 1][colTwo-1] = value;
                    colTwo += 1;
                    if (rowTwo == Integer.parseInt(onRowTwoInput.getText())){
                        rowTwo += 1;
                    }
                }else {
                    rowTwo += 1;
                    colTwo = 1;
                    m2.values[rowTwo- 1][colTwo-1] = value;
                    colTwo += 1;
                }
            }
        }
        if (rowOne <= Integer.parseInt(onRowOneInput.getText())) {
            enterElementText.setText("Enter Matrix Elements M1("+ rowOne +"X" + colOne+")");
        } else {
            enterElementText.setText("Enter Matrix Elements M2("+ rowTwo +"X" + colTwo+")");
        }
    }
}