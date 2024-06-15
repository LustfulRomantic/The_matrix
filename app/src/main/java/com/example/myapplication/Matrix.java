package com.example.myapplication;

import java.util.*;

public class Matrix {
    private Cell[][] matrix;
    private int rows;
    private int cols;

    public Matrix(){
        this.rows = 5;
        this.cols = 5;
        this.matrix = new Cell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = new Cell(i, j);
    }
    public Matrix(Cell[][] matrix, int rows, int cols){
        this.matrix = matrix;
        this.rows = rows;
        this.cols = cols;
    }
    public Matrix(int rows, int cols){
        this.matrix = new Cell[rows][cols];
        for (int i = 0; i<rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = new Cell(i, j);
    }
    public boolean isCellClear (int x, int y) {
        return getCellValue(x,y) == 0;
    }
    public int getRows(){return this.rows;}
    public int getCols(){return this.cols;}
    private Integer getCellValue (int x, int y) {
        return matrix[x][y].getVal();
    }

    public Cell getCell(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < cols) {
            return matrix[row][column];
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        String mat = "123\n123";

        return mat;
    }

    public ArrayList<Cell> getNeighbors(Cell cell){
        ArrayList<Cell> neighbors = new ArrayList<>();
        if (getCell(cell.getRow()-1, cell.getColumn()) != null)
            neighbors.add(getCell(cell.getRow()-1, cell.getColumn()));
        if (getCell(cell.getRow()+1, cell.getColumn()) != null)
            neighbors.add(getCell(cell.getRow()+1, cell.getColumn()));
        if (getCell(cell.getRow(), cell.getColumn()-1) != null)
            neighbors.add(getCell(cell.getRow(), cell.getColumn()-1));
        if (getCell(cell.getRow(), cell.getColumn()+1) != null)
            neighbors.add(getCell(cell.getRow(), cell.getColumn()+1));
        return neighbors;
    }

    public void setCellValue(int row, int column, int value) {
        if (row >= 0 && row < rows && column >= 0 && column < cols) {
            matrix[row][column].setVal(value);
        }
    }
}
