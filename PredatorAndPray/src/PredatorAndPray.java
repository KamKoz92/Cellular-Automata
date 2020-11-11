package PredatorAndPray.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;


public class PredatorAndPray extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private Grid grid;

    private int gridSize;
    private Random random;

    public PredatorAndPray() {
        gridSize = 250;
        random = new Random();
        grid = new Grid(gridSize,random);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Grid copyGrid = new Grid(gridSize);

        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                if(grid.cell(i,j).isPrey()) {
                    preyMovement(i, j, copyGrid);
                } else if(grid.cell(i,j).isPredator()) {
                    predatorMovement(i, j, copyGrid);
                }
            }
        }
        grid = copyGrid;
    }

    private void preyMovement(int i, int j, Grid copyGrid) {
        int ir = random.nextInt(3) - 1;
        int jr = random.nextInt(3) - 1;

        try {
            if(grid.cell(i+ir,j+jr).isEmpty() && copyGrid.cell(i+ir,j+jr).isEmpty()) {
                copyGrid.set(i+ir, j+jr, grid.cell(i,j));
                copyGrid.cell(i+ir, j+jr).increaseLifeTime();
                if(copyGrid.cell(i+ir, j+jr).getLifetime() == Cell.PREY_LIFE) {
                    copyGrid.set(i+ir, j+jr, new Cell(Color.green));
                    copyGrid.set(i, j, new Cell(Color.green));
                }
            } else {
                copyGrid.set(i, j, grid.cell(i,j));
            }
        } catch(Exception e) {
            copyGrid.set(i, j, grid.cell(i,j));
        }
    }
    private void predatorMovement(int i, int j, Grid copyGrid) {
        int ir = random.nextInt(3) - 1;
        int jr = random.nextInt(3) - 1;

        try {
            if(grid.cell(i+ir,j+jr).isEmpty() && copyGrid.cell(i+ir,j+jr).isEmpty()) {
                copyGrid.set(i+ir, j+jr, grid.cell(i,j));
                copyGrid.cell(i+ir, j+jr).increaseLifeTime();
                if(copyGrid.cell(i+ir, j+jr).getLifetime() == Cell.PREDATOR_LIFE) {
                    copyGrid.set(i+ir, j+jr, new Cell(Color.black));
                }
            } else if(grid.cell(i+ir,j+jr).isPrey()){
                copyGrid.set(i+ir, j+jr, new Cell(Color.red));
                copyGrid.set(i, j, new Cell(Color.red));
            } else {
                copyGrid.set(i, j, grid.cell(i,j));
            }
        } catch(Exception e) {
            copyGrid.set(i, j, grid.cell(i,j));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.drawGrid(g);
        super.repaint();
    }
}
