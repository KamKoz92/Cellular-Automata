import javax.swing.Timer;

public class Main {
    private static PredatorAndPray pap;
    private static Timer timer;

    public static void main(String[] args) {

        pap = new PredatorAndPray();
        new Window(pap);

        timer = new Timer(20, pap);
        timer.start();
    }
}
