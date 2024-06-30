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
    public MazeMatrix(Cell[][] matrix, int rows, int cols, Cell start_point, Cell end_point){
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
}
