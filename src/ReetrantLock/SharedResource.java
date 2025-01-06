package ReetrantLock;

import java.util.concurrent.locks.Lock;

public class SharedResource {

    public void produce(Lock lock){
        lock.lock();
        System.out.println("Locked acquired");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            lock.unlock();
            System.out.println("Lock Released");
        }
    }
}
