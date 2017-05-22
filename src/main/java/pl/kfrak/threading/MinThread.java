package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class MinThread extends Thread {
    private int[] data;
    private int start;
    private int stop;
    private int foundMin;


    public MinThread(int[] data, int start, int stop) {
        this.data = data;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
        int min = data[start];
        for (int i = start; i <= stop; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        this.foundMin = min;
    }

    int getMin() {
        return foundMin;
    }
}
