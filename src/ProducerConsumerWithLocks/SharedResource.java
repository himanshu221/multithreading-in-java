package ProducerConsumerWithLocks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final Queue<Integer> buffer;
    private final int bufferSize;
    private final ReentrantLock lock;
    private final Condition condition;

    SharedResource(int size, ReentrantLock lock){
        buffer = new LinkedList<>();
        bufferSize = size;
        this.lock = lock;
        condition = lock.newCondition();
    }

    public void produceItem(int item){

        System.out.println("Inside producer");
        System.out.println("Trying to acquire lock by producer");
        lock.lock();
        System.out.println("Lock acquired by producer");

        while(bufferSize == buffer.size()){
            try {
                System.out.println("Producer Thread : " + Thread.currentThread().getName() + "is waiting since buffer is full");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(item);
        condition.signal();
        lock.unlock();
        System.out.println("Lock released by producer");
    }

    public int consumeItem(){
        System.out.println("Inside consumer");
        System.out.println("Trying to acquire lock by consumer");
        lock.lock();
        System.out.println("Lock acquired by consumer");

        while(buffer.isEmpty()){
            try {
                System.out.println("Consumer Thread : " + Thread.currentThread().getName() + "is waiting since buffer is empty");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int item = buffer.remove();
        condition.signal();
        lock.unlock();
        System.out.println("Lock released by consumer");

        return item;
    }
}
