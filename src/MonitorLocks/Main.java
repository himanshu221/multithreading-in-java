package MonitorLocks;

public class Main {
    public static void main(String[] args){
        // MlExample object will be the shared resource between all 3 threads
        MLExample mlExample = new MLExample();

        Thread thread1 = new Thread(mlExample::task1);
        // thread 2 will have to wait for thread 1 to release monitor lock
        // on the object before it acquires monitor lock on it and goes
        // inside synchronised block
        Thread thread2 = new Thread(mlExample::task2);
        Thread thread3 = new Thread(mlExample::task3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
