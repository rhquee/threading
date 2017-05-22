package pl.kfrak.threading;

/**
 * Created by E550 on 2017-05-22.
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
        MyMessage message = new MyMessage();

        MyConsumer consumer = new MyConsumer(message);
        MyProducer producer = new MyProducer(message);
        consumer.start();
        producer.start();


    }
}
