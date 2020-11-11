package PredatorAndPray2.src;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Grid {

    private Cell[][] grid;
    private int size;

    public Grid(int size) {
        this.size = size;
        grid = new Cell[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                grid[x][y] = new Cell(Color.BLACK);
            }
        }
    }

    public Grid(int size, Random random) {
        this.size = size;
        grid = new Cell[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(random.nextBoolean()) {
                    grid[x][y] = new Cell(Color.BLACK);
                } else {
                    if(random.nextBoolean()) {
                        grid[x][y] = new Cell(Color.GREEN);
                    } else {
                        grid[x][y] = new Cell(Color.RED);
                    }
                }
            }
        }
    }

    public Cell cell(int x, int y) {
        return grid[x][y];
    }
    
    public void setCell(int x, int y, Cell cell) {
        grid[x][y] = cell;
    }

	public void draw(Graphics g) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                g.setColor(grid[x][y].getColor());
                g.fillRect(x*2, y*2, 2, 2);
            }
        }
	}
    
}


