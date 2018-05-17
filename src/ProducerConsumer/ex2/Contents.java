package ProducerConsumer.ex2;

/**
 * Created by home on 17.05.2018.
 */
public class Contents {
    private String contents;
    private boolean available = false;

    public synchronized String getContents(){
        while (!available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(String contents){
        while (available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.contents = contents;
        available = true;
        notifyAll();
    }
}
