package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class ThreadingFactorial {
    public static void main(String[] args) throws InterruptedException {
        long[] factorials = new long[2];

        Thread threadFactorial20 = new Thread() {
            @Override
            public void run() {
                long factorial = 1;
                for (int i = 2; i <= 20; i++) {
                    factorial *= i;
                }
                factorials[0] = factorial;
            }
        };

        Thread threadFactorial25 = new Thread() {
            @Override
            public void run() {
                long factorial = 1;
                for (int i = 2; i <= 25; i++) {
                    factorial *= i;
                }
                factorials[1] = factorial;
            }
        };

        threadFactorial20.start();
        threadFactorial25.start();

        threadFactorial20.join();
        threadFactorial25.join();

        System.out.println("Factorial(20): " + factorials[0]);
        System.out.println("Factorial(25): " + factorials[1]);



    }
}
