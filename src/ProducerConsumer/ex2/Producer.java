package ProducerConsumer.ex1.ex2.ex4;

/**
 * Created by home on 17.05.2018.
 */
public class Producer extends Thread{
    private Contents contents;
    private  int number;

    public Producer(Contents contents, int number) {
        this.contents = contents;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String cont = "Shit happens [" + i + "]";
            contents.put(cont);
            System.out.printf("Producer # %d put: %s%n", this.number, cont);
            try{
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
