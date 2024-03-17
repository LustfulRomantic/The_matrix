package com.example.myapplication;
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
    public int[] getIndex(){return new int[]{this.row, this.column};}
    public int getVal(){return this.value;}

}

//Additional Properties in Cell Class:
//Include properties in the Cell class to represent additional characteristics that might be relevant for a maze, such as whether the cell is a wall, a starting point, an endpoint, or a path cell.
//Add methods in the Cell class to set and retrieve these properties, allowing for easy identification and manipulation of cell types.