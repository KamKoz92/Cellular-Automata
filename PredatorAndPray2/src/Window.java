package PredatorAndPray2.src;

import javax.swing.JFrame;

public class Window {

    public Window(PredatorAndPray predatorAndPrayComponent){
        JFrame frame = new JFrame("PredatorAndPray2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setContentPane(predatorAndPrayComponent);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}