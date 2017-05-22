package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class ExampleThreads extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Example Thread " + i);
        }
    }
}
