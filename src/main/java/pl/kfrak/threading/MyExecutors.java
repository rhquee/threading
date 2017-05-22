package pl.kfrak.threading;

import java.util.concurrent.*;

/**
 * Created by E550 on 2017-05-22.
 */
public class MyExecutors {

    // każdy wątek zawsze czyta z tego samego miejsca
    volatile int x = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        executorService.submit(runnable);


        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 4;
            }
        };


        Future<Integer> future = executorService.submit(callable);

        while(!future.isDone()){
            System.out.println("Waiting for callable");
            Thread.sleep(100);
        }

        System.out.println(future.get());



    }
}
