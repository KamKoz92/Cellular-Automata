package PredatorAndPray2.src;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

import javax.swing.JPanel;


public class PredatorAndPray extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final int SIZE = 250;
    private Random random;
    private Grid grid;
    private Float H;
    private Float P;

    public PredatorAndPray(Float H, Float P) {
        random = new Random();    
        grid = new Grid(SIZE, random);
        this.H = H;
        this.P = P;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        Grid newGrid = new Grid(SIZE);

        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                if(grid.cell(x, y).isPrey()) {
                    prayMovment(x, y, newGrid);
                } else if(grid.cell(x, y).isPredator()) {
                    predatorMovment(x, y, newGrid);
                }
            }
        }
        removeNotFeededPredators(newGrid);

		grid = newGrid;
    }

    private void prayMovment(int x, int y, Grid newGrid) {
        newGrid.setCell(x, y, grid.cell(x, y));
        
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else {
                    try {
                        if(grid.cell(x + i, y + j).isEmpty() && grid.cell(x + i, y + j).isEmpty()) {
                            if(random.nextFloat() <= H) {
                                newGrid.setCell(x + i, y + j, new Cell(Color.GREEN));
                            }
                        }  
                    } catch (Exception e) {

                    }
                    
                }
            }
        }
    }
    
    private void predatorMovment(int x, int y, Grid newGrid) {
        newGrid.setCell(x, y, grid.cell(x, y));

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else {
                    try {
                        if(grid.cell(x + i, y + j).isPrey()) {
                            if(random.nextFloat() <= P) {
                                newGrid.setCell(x + i, y + j, new Cell(Color.RED));
                            }
                        }  
                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    public void removeNotFeededPredators(Grid newGrid) {
        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                if(newGrid.cell(x, y).isPredator()) {
                    removeIfNotFeeded(x, y, newGrid);
                }
            }
        }
    }

    private void removeIfNotFeeded(int x, int y, Grid newGrid) {
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                try {
                    if(i == 0 && j == 0) {
                        continue;
                    } else if(newGrid.cell(x + i, y + j).isPrey()) {
                        return;
                    }
                } catch(Exception e) {

                }
            }
        }
        newGrid.setCell(x, y, new Cell(Color.BLACK));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.draw(g);
        super.repaint();
    }
}
