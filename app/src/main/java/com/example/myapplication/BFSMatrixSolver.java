package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSMatrixSolver implements MatrixSolver {
    private MazeMatrix maze; // The maze to be solved
    private boolean[][] visited; // An array to track visited cells
    private Queue<Cell> queue; // A queue containing cells to be visited
    private HashMap<Cell, Cell> parentMap; // A mapping of child cells to their parent cells in the solution path

    // Constructor
    public BFSMatrixSolver(MazeMatrix maze) {
        this.maze = maze;
        visited = new boolean[maze.getRows()][maze.getCols()];
        queue = new LinkedList<>();
        parentMap = new HashMap<>();
    }

    // Check if the maze is solvable
    public boolean isSolvable() {
        return solve() != null;
    }

    // Solve the maze using BFS and return the solution path
    public ArrayList<Cell> solve() {
        Cell startCell = maze.getStartPoint();
        Cell endCell = maze.getEndPoint();

        // Initialize the BFS algorithm with the start cell
        queue.add(startCell);
        visited[startCell.getRow()][startCell.getColumn()] = true;

        // Continue BFS until the queue is empty
        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            // If the current cell is the end cell, reconstruct and return the solution path
            if (currentCell.getIndex() == endCell.getIndex()) {
                return reconstructPath(startCell, endCell);
            }

            // Explore passable neighbors of the current cell
            for (Cell neighbor : getPassableNeighbors(currentCell)) {
                // Add unvisited neighbors to the queue and mark them as visited
                if (!visited[neighbor.getRow()][neighbor.getColumn()]) {
                    queue.add(neighbor);
                    visited[neighbor.getRow()][neighbor.getColumn()] = true;
                    parentMap.put(neighbor, currentCell); // Track parent-child relationship for path reconstruction
                }
            }
        }

        // If no solution is found, return null
        return null;
    }

    // Reconstruct the solution path using the parent-child relationships
    private ArrayList<Cell> reconstructPath(Cell startCell, Cell endCell) {
        ArrayList<Cell> path = new ArrayList<>();
        Cell currentCell = endCell;

        // Traverse from the end cell to the start cell using parent pointers
        while (currentCell.getIndex() != startCell.getIndex()) {
            path.add(0, currentCell); // Add cells to the beginning of the path list
            currentCell = parentMap.get(currentCell); // Move to the parent cell
        }

        path.add(0, startCell); // Add the start cell to complete the path
        return path;
    }

    // Get passable neighbors of a given cell
    private List<Cell> getPassableNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.getRow();
        int col = cell.getColumn();

        // Check adjacent cells (up, down, left, right) and add them to the neighbors list if they are passable
        if (isValidMove(row - 1, col)) { // Up
            neighbors.add(maze.getCell(row - 1, col));
        }
        if (isValidMove(row + 1, col)) { // Down
            neighbors.add(maze.getCell(row + 1, col));
        }
        if (isValidMove(row, col - 1)) { // Left
            neighbors.add(maze.getCell(row, col - 1));
        }
        if (isValidMove(row, col + 1)) { // Right
            neighbors.add(maze.getCell(row, col + 1));
        }

        return neighbors;
    }

    // Check if a move to the specified row and column is valid (within bounds and not blocked)
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < maze.getRows() && col >= 0 && col < maze.getCols()
                && maze.isCellClear(row, col); // Check if the cell is within bounds and clear (not blocked)
    }
}
