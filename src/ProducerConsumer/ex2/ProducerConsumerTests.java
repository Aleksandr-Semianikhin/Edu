package ProducerConsumer.ex1.ex2.ex4;

/**
 * Created by home on 17.05.2018.
 */
public class ProducerConsumerTests {
    public static void main(String[] args) {

        Contents cont = new Contents();
        Producer producer = new Producer(cont, 11);
        Consumer consumer = new Consumer(cont, 11);
        producer.start();
        consumer.start();
    }
}
