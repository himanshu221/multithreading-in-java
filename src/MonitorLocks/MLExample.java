package MonitorLocks;

public class MLExample {
    synchronized public void task1(){
        System.out.println("Pre-sleep task1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Post-sleep task1");
    }

    public void task2(){
        System.out.println("Pre-sync block task2");
        synchronized (this) {
            System.out.println("In-sync block task2 by : " + Thread.currentThread().getName());
        }
    }

    public void task3(){
        System.out.println("Inside task3");
    }
}
