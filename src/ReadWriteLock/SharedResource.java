package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    ReadWriteLock lock;

    SharedResource(ReadWriteLock lock){
        this.lock = lock;
    }
    public void produce(){
        lock.readLock().lock();
        System.out.println("Read Lock Acquired by : " + Thread.currentThread().getName());

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            //Something
        }finally {
            lock.readLock().unlock();
            System.out.println("Read Lock Released by :" + Thread.currentThread().getName());
        }
    }

    public void consume(){
        lock.writeLock().lock();
        System.out.println("Write Lock Acquired by : " + Thread.currentThread().getName());

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            //Something
        }finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock Released by :" + Thread.currentThread().getName());
        }
    }
}
