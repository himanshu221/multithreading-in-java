package OptimisticStampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args){
        StampedLock lock = new StampedLock();
        SharedResource sharedResource = new SharedResource(lock);

        Thread thread1 = new Thread(sharedResource::produce);
        Thread thread2 = new Thread(sharedResource::consume);

        thread1.start();
//        thread2.start();

    }
}
