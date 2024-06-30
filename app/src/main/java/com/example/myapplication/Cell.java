package com.example.myapplication;
import androidx.annotation.NonNull;

import java.util.*;

public class Cell {
    private int row;
    private int column;
    private int value;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.value = 0;
    }
    public Cell(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.value = value;
    }
    public void setIndex(int row, int column){
        this.row = row;
        this.column = column;
    }
    public void setVal(int value){this.value = value;}
    public int[] getIndex(){return new int[]{this.column, this.row};}
    public int getVal(){return this.value;}
    public int getRow(){return this.row;}
    public int getColumn(){return this.column;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Cell cell = (Cell) obj;
        return row == cell.row && column == cell.column && value == cell.value;
    }

    @Override
    public int hashCode() {
        // Combine row and col values into a single hash code
        return Objects.hash(row, column, value);
    }

    @NonNull
    @Override
    public String toString() {
        return "["+"("+this.column+","+this.row+") - "+this.value+"]";
    }
}