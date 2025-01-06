package Semaphores;

import java.util.concurrent.Semaphore;

public class SharedResource {
    private final Semaphore semaphore;

    SharedResource(int permits){
        semaphore = new Semaphore(permits);
    }

    public void task(){
        try {
            semaphore.acquire();
            System.out.println("lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
            System.out.println("lock released by : " + Thread.currentThread().getName());
        }
    }
}
