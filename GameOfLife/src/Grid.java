package GameOfLife.src;

import java.awt.Graphics;

public class Grid {

    private Cell[][] grid;
    private int xSize, ySize;
    public Grid(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Cell[xSize][ySize];
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                grid[x][y] = new Cell(false);
            }
        }

    }

	public void draw(Graphics g) {
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                g.setColor(grid[x][y].getColor());
                g.fillRect(x*20, y*20, 20, 20);
            }
        }
    }
    
    public Cell cell(int x, int y) {
        return grid[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        grid[x][y] = cell;
    }
    

    public Grid(int xSize, int ySize, int pattern) {
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Cell[xSize][ySize];
        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                grid[x][y] = new Cell(false);
            }
        }


        if(pattern == 1) { // glider pattern
            grid[1][1] = new Cell(true);
            grid[2][2] = new Cell(true);
            grid[3][2] = new Cell(true);
            grid[2][3] = new Cell(true);
            grid[1][3] = new Cell(true);

        } else if(pattern == 2) { // oscilator patterns
            grid[21][2] = new Cell(true); // blinker
            grid[22][2] = new Cell(true);
            grid[23][2] = new Cell(true);

            grid[16][16] = new Cell(true); // toad
            grid[17][16] = new Cell(true);
            grid[18][16] = new Cell(true);
            grid[17][15] = new Cell(true);
            grid[18][15] = new Cell(true);
            grid[19][15] = new Cell(true);
        } else if(pattern == 3) { //gosper glider gun
            grid[1][5] = new Cell(true);
            grid[1][6] = new Cell(true);
            grid[2][5] = new Cell(true);
            grid[2][6] = new Cell(true);

            grid[11][5] = new Cell(true);
            grid[11][6] = new Cell(true);
            grid[11][7] = new Cell(true);

            grid[12][4] = new Cell(true);
            grid[12][8] = new Cell(true);

            grid[13][3] = new Cell(true);
            grid[13][9] = new Cell(true);
            grid[14][3] = new Cell(true);
            grid[14][9] = new Cell(true);

            grid[15][6] = new Cell(true);

            grid[16][4] = new Cell(true);
            grid[16][8] = new Cell(true);

            grid[17][5] = new Cell(true);
            grid[17][6] = new Cell(true);
            grid[17][7] = new Cell(true);

            grid[18][6] = new Cell(true);

            grid[21][3] = new Cell(true);
            grid[21][4] = new Cell(true);
            grid[21][5] = new Cell(true);

            grid[22][3] = new Cell(true);
            grid[22][4] = new Cell(true);
            grid[22][5] = new Cell(true);

            grid[23][2] = new Cell(true);
            grid[23][6] = new Cell(true);

            grid[25][1] = new Cell(true);
            grid[25][2] = new Cell(true);
            grid[25][6] = new Cell(true);
            grid[25][7] = new Cell(true);

            grid[35][4] = new Cell(true);
            grid[35][5] = new Cell(true);
            grid[36][4] = new Cell(true);
            grid[36][5] = new Cell(true);
        }

    }
}
