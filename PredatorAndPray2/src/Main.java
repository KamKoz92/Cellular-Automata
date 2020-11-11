package PredatorAndPray2.src;

import javax.swing.Timer;

public class Main {
    private static PredatorAndPray pap;
    private static Timer timer;

    public static void main(String[] args) {
        int delayTimeInMs = 30;
        Float H = 0.3f; // prey reproduction chance
        Float P = 0.3f; // predator reproduction chance



        pap = new PredatorAndPray(H, P);
        new Window(pap);

        timer = new Timer(delayTimeInMs, pap);
        timer.start();
    }
}
