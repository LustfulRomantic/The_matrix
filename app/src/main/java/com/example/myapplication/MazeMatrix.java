package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MazeMatrix extends Matrix {
    private Cell start_point;
    private Cell end_point;
    private HashMap<String, ArrayList<Cell>> solutions;
    public MazeMatrix(){
        super();
        this.start_point = super.getCell(0, 0);
        this.end_point = super.getCell(4, 4);
        this.solutions = new HashMap<>();
    }
    public MazeMatrix(ArrayList<ArrayList<Cell>> matrix, int rows, int cols, Cell start_point, Cell end_point){
        super(matrix, rows, cols);
        this.start_point = start_point;
        this.end_point = end_point;
        this.solutions = new HashMap<>();
    }
    public Cell getStartPoint(){return this.start_point;}
    public Cell getEndPoint(){return this.end_point;}
    public Set<String> getAllAlgorithmNames() {
        return solutions.keySet();
    }
    public int getSolutionLength(String algorithmName) {
        ArrayList<Cell> solution = solutions.get(algorithmName);
        if (solution != null) {
            return solution.size();
        } else {
            return -1; // Indicate that the solution was not found
        }
    }
    public void addSolution(String algorithmName, ArrayList<Cell> solution) {
        solutions.put(algorithmName, solution);
    }
    public List<Cell> getPassableNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.getRow();
        int col = cell.getColumn();

        // Check adjacent cells
        if (isValidMove(row - 1, col)) { // Up
            neighbors.add(getCell(row - 1, col));
        }
        if (isValidMove(row + 1, col)) { // Down
            neighbors.add(getCell(row + 1, col));
        }
        if (isValidMove(row, col - 1)) { // Left
            neighbors.add(getCell(row, col - 1));
        }
        if (isValidMove(row, col + 1)) { // Right
            neighbors.add(getCell(row, col + 1));
        }

        return neighbors;
    }
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < getRows() && col >= 0 && col < getCols()
                && isCellClear(row, col);
    }
    //Implement specific maze-related functionalities in the MazeMatrix class, such as generating a maze grid with walls, and handling maze-specific operations.
    //Override methods from the superclass as needed to customize their behavior for the maze context.
}
