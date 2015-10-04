package rmsp;

import java.util.Random;

/**
 * Created by michal on 04.10.2015.
 */
public class Generator extends Thread {
    private final App app;
    private final Random random;

    public Generator(App app) {
        this.app = app;
        random = new Random();
    }

    public void run() {
        while(true) {
            app.setValues(getRandomValues(random.nextInt(20) + 10));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Value[] getRandomValues(int size) {
        Value[] values = new Value[size];
        for (int i = 0; i < size; i++) {
            values[i] = new Value();
            values[i].setConfidenceMin(2 + random.nextDouble());
            values[i].setValue(3 + random.nextDouble());
            values[i].setConfidenceMax(4 + random.nextDouble());
        }
        return values;
    }
}
