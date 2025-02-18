package com.example.matrixoperation;

import java.util.Random;

public class Matrix {
//    int noOfRows, noOfCols;
    int[][] values;


    public void setMatrix(int rows, int cols){
        values = new int[rows][cols];
        Random r = new Random();
        int i,j;
        for(i=0; i<rows;i++){
            for(j=0;j<cols;j++){
                values[i][j] = r.nextInt(100);
            }
        }
    }

    public void showMatrix(){
        Random r = new Random();
        int i,j;
        for(i=0; i<values.length;i++){
            for(j=0;j<values[i].length;j++){
                System.out.print(r.nextInt(100) + " ");
            }
            System.out.println();
        }
    }

    public void transposeMatrix(){

    }
}
