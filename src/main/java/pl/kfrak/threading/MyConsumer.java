package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class MyConsumer extends Thread {
    private MyMessage message;

    public MyConsumer(MyMessage message) {

        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Consumer started");

        synchronized (message){
            try {
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumer works");
        System.out.println(message.getMsg());

    }
}
