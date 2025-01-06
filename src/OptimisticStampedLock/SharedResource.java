package OptimisticStampedLock;


import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a;
    StampedLock lock;

    SharedResource(StampedLock lock){
        this.lock = lock;
        a = 10;
    }

    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try{
            Thread.sleep(5000);
            a = 20;
            if(lock.validate(stamp)){
                System.out.println("var is updated to :" + a);
            }else{
                a = 10;
                System.out.println("Rolling back the change");
            }
        }catch (Exception e){
            // Something Semething
        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired");
        a = 30;
        System.out.println("var is updated to :" + a);
        lock.unlock(stamp);
        System.out.println("Write lock released");

    }
}
