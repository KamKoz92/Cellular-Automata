package PredatorAndPray.src;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Grid {

    private Cell grid[][];
    private int gridSize;
    public Grid(int gridSize) { 
        this.gridSize = gridSize;
        grid = new Cell[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                grid[i][j] = new Cell(Color.black);
            }
        }
    }

    public Grid(int gridSize, Random random) {
        this.gridSize = gridSize;
        grid = new Cell[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                if(random.nextFloat() < 0.99f) {
                    grid[i][j] = new Cell(Color.black);
                } else {
                    grid[i][j] = random.nextBoolean() ? new Cell(Color.green) : new Cell(Color.red);
                    // grid[i][j] = new Cell(Color.green);
                }
            }
        }
    }

    public Cell cell(int i, int j) {
        return grid[i][j];
    }
    
    public void set(int i, int j, Cell cell) {
        grid[i][j] = cell;
    }
    public void drawGrid(Graphics g) {
        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                g.setColor(grid[i][j].getColor());
                g.fillRect(i*2, j*2, 2, 2);
            }
        }
    }
}
