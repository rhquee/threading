package pl.kfrak.threading;

import java.util.List;
import java.util.Random;

/**
 * Created by E550 on 2017-05-22.
 */
public class ThreadingArrayMin2 {


    private final static int THREADS_NUMBER = 3300;

    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[2_000_000];

        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }

        List<MinThread> threads = new ArrayList<>();


        int part = data.length / THREADS_NUMBER;

        for (int i = 0; i < THREADS_NUMBER; i++) {
            if (i == THREADS_NUMBER - 1) {
                threads.add(new MinThread(data, i * part, data.length - 1));
            } else {
                threads.add(new MinThread(data, i * part, (i + 1) * part - 1));
            }
            // to to samo co
//			threads.add(new MinThread(data, i * part, (i == THREADS_NUMBER - 1) ? data.length : (i + 1) * part - 1));
        }

        long start = System.nanoTime();
        for (MinThread thread : threads) {
            thread.start();
        }

        for (MinThread thread : threads) {
            thread.join();
        }

        int ultimateMin = threads.get(0).getMin();
        for (MinThread thread : threads) {
            if (thread.getMin() < ultimateMin) {
                ultimateMin = thread.getMin();
            }
        }
        double duration = (System.nanoTime() - start) / 1_000_000_000d;
        System.out.println("Minimalna wartość w tablicy: " + ultimateMin);
        System.out.println("Ilość wątków: " + THREADS_NUMBER);
        System.out.println("Czas trwania: " + duration + "s");


    }
}
