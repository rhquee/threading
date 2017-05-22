package pl.kfrak.threading;

import java.util.Random;

/**
 * Created by E550 on 2017-05-22.
 */
public class ThreadingArrayMin {
    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[1_000_000];

        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }

        // WYSZUKANIE MINUMUM W TABLICY
//		int min = data[0];
//		for (int i = 0; i < data.length; i++) {
//			if(data[i] < min){
//				min = data[i];
//			}
//		}

        int[] mins = new int[2];

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int min = data[0];
                for (int i = 0; i < data.length/2; i++) {
                    if (data[i] < min) {
                        min = data[i];
                    }
                }
                mins[0] = min;
            }
        };
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int min = data[data.length/2];
                for (int i = data.length/2; i < data.length; i++) {
                    if (data[i] < min) {
                        min = data[i];
                    }
                }
                mins[1] = min;
            }
        };
        thread2.start();

        thread1.join();
        thread2.join();

        int min = mins[0] < mins[1] ? mins[0] : mins[1];

        // TO SAMO CO
//		int min2 = 0;
//		if(mins[0] < mins[1]){
//			min2 = mins[0];
//		} else {
//			min2 = mins[1];
//		}

        System.out.println("Minimalna wartość w tablicy: " + min);


    }
}
