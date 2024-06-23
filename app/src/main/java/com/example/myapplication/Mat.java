package com.example.myapplication;

import java.util.Arrays;

public class Mat {
    private int start_cal;
    private int start_raw;
    private int end_cal;
    private int end_raw;
    private int[][] arr;

    public Mat() {
    }

    public Mat(int start_cal, int start_raw, int end_cal, int end_raw, int[][] arr) {
        this.start_cal = start_cal;
        this.start_raw = start_raw;
        this.end_cal = end_cal;
        this.end_raw = end_raw;
        this.arr = arr;
    }

    public int getStart_cal() {
        return start_cal;
    }

    public int getStart_raw() {
        return start_raw;
    }

    public int getEnd_cal() {
        return end_cal;
    }

    public int getEnd_raw() {
        return end_raw;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setStart_cal(int start_cal) {
        this.start_cal = start_cal;
    }

    public void setStart_raw(int start_raw) {
        this.start_raw = start_raw;
    }

    public void setEnd_cal(int end_cal) {
        this.end_cal = end_cal;
    }

    public void setEnd_raw(int end_raw) {
        this.end_raw = end_raw;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public MazeMatrix getMaze(){
        Matrix m = new Matrix();
        for(int i = 0; i< m.getRows(); i++)
            for(int j = 0; j< m.getCols(); j++){
                m.setCellValue(i,j,arr[i][j]);
            }
        MazeMatrix mm = new MazeMatrix(m.getMatrix(), m.getRows(), m.getCols(), new Cell(start_raw, start_cal), new Cell(end_raw, end_cal));
        return mm;
    }
    public void setTestMaze(){

    }

    @Override
    public String toString() {
        return "Mat{" +
                "start_cal=" + start_cal +
                ", start_raw=" + start_raw +
                ", end_cal=" + end_cal +
                ", end_raw=" + end_raw +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
