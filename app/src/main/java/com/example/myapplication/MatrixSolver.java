package com.example.myapplication;

import java.util.ArrayList;

public interface MatrixSolver {
    boolean isSolvable();
    ArrayList<Cell> solve();
}
//not finished
//Define classes for different maze-solving algorithms, such as BFSMatrixSolver.
//Implement methods in these solver classes to navigate through the maze grid, find a path from the start to the end point, and return the solution path.
//Utilize the Matrix and Cell classes to represent the maze and perform operations on it.