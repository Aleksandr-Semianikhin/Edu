package ProducerConsumer.ex2;

/**
 * Created by home on 17.05.2018.
 */
public class Consumer extends Thread {
    private Contents contents;
    private  int number;

    public Consumer(Contents contents, int number) {
        this.contents = contents;
        this.number = number;
    }

    public void run(){
        String value;
        for (int i = 0; i < 100; i++) {
            value = contents.getContents();
            System.out.printf("Consumer # %d got: %s%n", number, value);
        }

    }
}
