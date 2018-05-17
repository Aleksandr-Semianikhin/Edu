package ProducerConsumer.ex1.ex2.ex3;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by home on 17.05.2018.
 */
public class SynchronousQueueDemo2 {

    public static void main(String[] args) {

        SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread("PRODUCER"){
            @Override
            public void run() {
                String product = "Shit Happens";
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put(product);//thread block here
                        System.out.printf("[%s] published product: %s %n", Thread.currentThread().getName(), product+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        Thread consumer = new Thread("CONSUMER"){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        String product = queue.take();//thread block here
                        System.out.printf("[%s] consumed product: %s %n", Thread.currentThread().getName(), product+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();

    }
}
