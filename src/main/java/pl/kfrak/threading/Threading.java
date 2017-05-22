package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class Threading {
    public static void main(String[] args) {

        ExampleThread thread = new ExampleThread();
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main Thread " + i);
        }

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("ABC");
            }
        };
        thread2.start();


        // Implementacja interfejsu runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("THREAD FROM RUNNABLE");
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread1.start();
        thread4.start();



    }
}
