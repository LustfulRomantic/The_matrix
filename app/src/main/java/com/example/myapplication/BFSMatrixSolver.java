package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrixSolver implements MatrixSolver {
    private MazeMatrix maze;
    private boolean[][] visited;
    private Queue<Cell> queue;
    private HashMap<Cell, Cell> parentMap;

    public BFSMatrixSolver(MazeMatrix maze) {
        this.maze = maze;
        visited = new boolean[maze.getRows()][maze.getCols()];
        queue = new LinkedList<>();
        parentMap = new HashMap<>();
    }

    public boolean isSolvable() {
        return solve() != null;
    }

    public ArrayList<Cell> solve() {
        Cell startCell = maze.getStartPoint();
        Cell endCell = maze.getEndPoint();

        queue.add(startCell);
        visited[startCell.getRow()][startCell.getColumn()] = true;

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            if (currentCell.getIndex() == endCell.getIndex()) {
                return reconstructPath(startCell, endCell);
            }
            for (Cell neighbor : maze.getPassableNeighbors(currentCell)) {
                if (!visited[neighbor.getRow()][neighbor.getColumn()]) {
                    queue.add(neighbor);
                    visited[neighbor.getRow()][neighbor.getColumn()] = true;
                    parentMap.put(neighbor, currentCell);
                }
            }
        }
        return null;
    }
    private ArrayList<Cell> reconstructPath(Cell startCell, Cell endCell) {
        ArrayList<Cell> path = new ArrayList<>();
        Cell currentCell = endCell;

        while (currentCell.getIndex() != startCell.getIndex()) {
            path.add(0, currentCell);
            currentCell = parentMap.get(currentCell);
        }

        path.add(0, startCell);
        return path;
    }

}
