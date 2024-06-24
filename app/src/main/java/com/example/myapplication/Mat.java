package com.example.myapplication;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mat implements Serializable {
    private int start_cal;
    private int start_raw;
    private int end_cal;
    private int end_raw;
    private ArrayList<Integer> arr;

    public Mat() {
    }

    public Mat(int start_cal, int start_raw, int end_cal, int end_raw, ArrayList<Integer> arr) {
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

    public ArrayList<Integer> getArr() {
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

    public void setArr(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Exclude
    public MazeMatrix getMaze(){
        Matrix m = new Matrix(6,5);
        for(int i = 0; i< m.getRows(); i++)
            for(int j = 0; j< m.getCols(); j++){
                m.setCellValue(i,j,arr.get(i*m.getCols()+j));
            }
        MazeMatrix mm = new MazeMatrix(m.getMatrix(), m.getRows(), m.getCols(), new Cell(start_raw, start_cal), new Cell(end_raw, end_cal));
        return mm;
    }
    public void setTestMaze(){
        this.start_cal =  0;
        this.start_raw = 4;
        this.end_cal = 4;
        this.end_raw = 1;
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

    @Override
    public String toString() {
        return "Mat{" +
                "start_cal=" + start_cal +
                ", start_raw=" + start_raw +
                ", end_cal=" + end_cal +
                ", end_raw=" + end_raw +
                //", arr=" + Arrays.toString(arr) +
                '}';
    }
}
