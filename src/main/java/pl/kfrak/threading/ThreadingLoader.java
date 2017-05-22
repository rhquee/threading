package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class ThreadingLoader {
    public static void main(String[] args) throws InterruptedException {

        Thread threadLoading = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        };
        threadLoading.start();

        Thread threadOperation = new Thread() {
            @Override
            public void run() {
                System.out.println("Zaczynam liczenie");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("Skończyłem liczenie");
            }
        };
        threadOperation.start();

        threadOperation.join();
        threadLoading.interrupt();





    }
}
