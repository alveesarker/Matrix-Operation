package com.example.matrixoperation;

import java.util.Random;

public class Matrix {
    //    int noOfRows, noOfCols;
    int[][] values;

    public Matrix() {
        values = null;
    }

    public Matrix(int row, int col) {
        values = new int[row][col];
        int i, j;
        for (i = 0; i < values.length; i++) {
            for (j = 0; j < values[i].length; j++) {
                values[i][j] = 0;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int i, j;
        for (i = 0; i < values.length; i++) {
            for (j = 0; j < values[i].length; j++) {
                str.append(values[i][j]).append(" ");
            }
            str.append("\n");
        }
        return (str.toString());
    }

//    public void setMatrix(int rows, int cols) {
//        values = new int[rows][cols];
//        Random r = new Random();
//        int i, j;
//        for (i = 0; i < rows; i++) {
//            for (j = 0; j < cols; j++) {
//                values[i][j] = r.nextInt(100);
//            }
//        }
//    }

//    public Matrix(int rows, int cols, int upperBound) {
//        values = new int[rows][cols];
//        Random r = new Random();
//        int i,j;
//        for(i=0; i<rows;i++){
//            for(j=0;j<cols;j++){
//                values[i][j] = r.nextInt(upperBound);
//            }
//        }
//    }

    public Matrix(int rows, int cols, int upperBound) {
        values = new int[rows][cols];
        Random r = new Random();
        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                values[i][j] = r.nextInt(upperBound);
            }
        }
    }

//    public void showMatrix() {
//        Random r = new Random();
//        int i, j;
//        for (i = 0; i < values.length; i++) {
//            for (j = 0; j < values[i].length; j++) {
//                System.out.print(this.values[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public Matrix addMatrices(Matrix m) {
        if (this.values.length == m.values.length && this.values[0].length == m.values[0].length) {
            Matrix temp = new Matrix();
            temp.values = new int[this.values.length][this.values[0].length];
            int i, j;
            for (i = 0; i < this.values.length; i++) {
                for (j = 0; j < this.values[i].length; j++) {
                    temp.values[i][j] = this.values[i][j] + m.values[i][j];
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    public Matrix multiplyMatrices(Matrix m) {
        if (this.values[0].length == m.values.length) {
            Matrix temp = new Matrix();
            temp.values = new int[this.values.length][m.values[0].length];
            int i, j, k;
            for (i = 0; i < this.values.length; i++) {
                for (j = 0; j < m.values[0].length; j++) {
                    for (k = 0; k < this.values[0].length; k++) {
                        temp.values[i][j] += this.values[i][k] * m.values[k][j];
                    }
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    public Matrix transposeMatrix() {
        Matrix temp = new Matrix();
        temp.values = new int[this.values[0].length][this.values.length];

        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[0].length; j++) {
                temp.values[j][i] = this.values[i][j];
            }
        }

        return temp;
    }
}
