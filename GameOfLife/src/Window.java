package GameOfLife.src;

import javax.swing.JFrame;

public class Window {

    public Window(GameOfLife gol, int xSize, int ySize){
        JFrame frame = new JFrame("PredatorAndPray");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(20 * xSize, 20 * ySize);
        frame.setContentPane(gol);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
