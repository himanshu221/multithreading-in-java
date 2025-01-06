package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private final Queue<Integer> buffer;
    private final int bufferSize;

    SharedResource(int bufferSize){
        buffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }
    public synchronized  void addItem(Integer item){
       while(buffer.size() == bufferSize){
           System.out.println("Buffer is full and producer thread is waiting");
           try {
               // Release the monitor lock on object
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       buffer.add(item);
       System.out.println("Item added :" + item);
       notify();
    }

    public synchronized int consumeItem(){
        while(buffer.size() == 0){
            System.out.println("Buffer is empty and consumer thread is waiting");
            try {
                // Release the monitor lock on object
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int item =  buffer.remove();
        notify();
        return item;
    }
}
