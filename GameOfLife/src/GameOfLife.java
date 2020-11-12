package GameOfLife.src;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameOfLife extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private int xSize;
    private int ySize;

    private Grid grid;

    public GameOfLife(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Grid(xSize,ySize,3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Grid newGrid = new Grid(xSize,ySize);

        for(int x = 0; x < xSize; x++) {
            for(int y = 0; y < ySize; y++) {
                if(grid.cell(x, y).getState()) {
                    LiveCellTransition(x, y, newGrid);
                } else {
                    DeadCellTransition(x, y, newGrid);
                }
            }
        }

        grid = newGrid;
    }

    private void DeadCellTransition(int x, int y, Grid newGrid) {
        int numberOfLiveCells = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else {
                    try {
                        if(grid.cell(x + i, y + j).getState()) {
                            numberOfLiveCells++;
                        }
                    } catch(Exception e) {

                    }
                    
                }
            }
        }
        if(numberOfLiveCells == 3) { 
            newGrid.setCell(x, y, new Cell(true));
        } else {
            newGrid.setCell(x, y, grid.cell(x, y));
        }

    }

    private void LiveCellTransition(int x, int y, Grid newGrid) {
        int numberOfLiveCells = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else {
                    try {
                        if(grid.cell(x + i, y + j).getState()) {
                            numberOfLiveCells++;
                        }
                    } catch(Exception e) {

                    }
                    
                }
            }
        }
        if(numberOfLiveCells < 2 || 3 < numberOfLiveCells) {
            newGrid.setCell(x, y, new Cell(false));
        } else {
            newGrid.setCell(x, y, grid.cell(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.draw(g);
        super.repaint();
    }
    
}
