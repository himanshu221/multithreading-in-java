package ReetrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            sharedResource1.produce(lock);
        });
        Thread thread2 = new Thread(() -> {
            sharedResource2.produce(lock);
        });

        thread1.start();
        thread2.start();
    }


}
