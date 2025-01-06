package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource sharedResource1 = new SharedResource(lock);

        Thread thread1 = new Thread(sharedResource1::produce);

        Thread thread2 = new Thread(sharedResource1::produce);

        Thread thread3 = new Thread(sharedResource1::consume);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
