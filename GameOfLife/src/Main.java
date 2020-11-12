package GameOfLife.src;

import javax.swing.Timer;

public class Main {

    private static Timer timer;
    private static GameOfLife gol;
    public static void main(String[] args) {

        int xSize = 75;
        int ySize = 55;

        gol = new GameOfLife(xSize, ySize);
        new Window(gol, xSize, ySize);

        timer = new Timer(100, gol);
        timer.start();
    }
}
