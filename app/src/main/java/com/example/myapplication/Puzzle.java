package com.example.myapplication;

import java.util.ArrayList;

/*
 * class holding the puzzle map
 */
public class Puzzle {
    private ArrayList<Integer> matrix;
    private int numOfRows = 3;
    private int numOfColumns = 10;

    //todo write a function that will init the matrix,
    // set its size and populated inital values per cell

    public boolean isCellClear (int x, int y) {
        if (getCellValue(x,y) == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private Integer getCellValue (int x, int y) {
        return matrix.get(x + y * (numOfColumns - 1));
    }
}
