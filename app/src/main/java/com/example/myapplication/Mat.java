package com.example.myapplication;

import android.util.Log;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;

public class Mat implements Serializable {
    private int start_col, start_row, end_col, end_row, rows_num, cols_num;
    private ArrayList<Integer> arr;

    public Mat() {
    }

    public Mat(int start_col, int start_row, int end_col, int end_row, int rows_num, int cols_num, ArrayList<Integer> arr) {
        this.start_col = start_col;
        this.start_row = start_row;
        this.end_col = end_col;
        this.end_row = end_row;
        this.rows_num = rows_num;
        this.cols_num = cols_num;
        this.arr = arr;
    }

    public int getStart_col() {
        return start_col;
    }

    public int getStart_row() {
        return start_row;
    }

    public int getEnd_col() {
        return end_col;
    }

    public int getEnd_row() {
        return end_row;
    }

    public ArrayList<Integer> getArr() {
        return arr;
    }

    public void setStart_col(int start_col) {
        this.start_col = start_col;
    }

    public void setStart_row(int start_row) {
        this.start_row = start_row;
    }

    public void setEnd_col(int end_col) {
        this.end_col = end_col;
    }

    public void setEnd_row(int end_row) {
        this.end_row = end_row;
    }

    public int getRows_num() {return rows_num;}

    public void setRows_num(int rows_num) {this.rows_num = rows_num;}

    public int getCols_num() {return cols_num;}

    public void setCols_num(int cols_num) {this.cols_num = cols_num;}

    public void setArr(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Exclude
    public MazeMatrix getMaze(){
        Matrix m = new Matrix(this.rows_num,this.cols_num);
        for(int i = 0; i< m.getRows(); i++)
            for(int j = 0; j< m.getCols(); j++){
                m.setCellValue(i,j,arr.get(i*m.getCols()+j));
            }
        MazeMatrix mm = new MazeMatrix(m.getMatrix(), m.getRows(), m.getCols(), new Cell(start_row, start_col), new Cell(end_row, end_col));
        return mm;
    }
    public void setTestMaze(){
        this.start_col =  0;
        this.start_row = 4;
        this.end_col = 4;
        this.end_row = 1;
        this.rows_num = 6;
        this.cols_num = 5;
        this.arr = new ArrayList<Integer>();
        for (int i = 0; i<30; i++){
            this.arr.add(0);
        }
        this.arr.set(3, 1);
        this.arr.set(5, 1);
        this.arr.set(12, 1);
        this.arr.set(16, 1);
        this.arr.set(19, 1);
        this.arr.set(21, 1);
        this.arr.set(23, 1);
        Log.d("Mat", this.arr.toString());
    }
}
