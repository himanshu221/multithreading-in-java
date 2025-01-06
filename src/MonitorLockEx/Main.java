package MonitorLockEx;

public class Main {
    public static void main(String[] args){
        SharedResource sr = new SharedResource();

        Thread producerThread = new Thread(() -> {
            try{
                System.out.println("Consumer thread is waiting");
                Thread.sleep(5000);
            }catch (Exception e){
                // Something
            }
           sr.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            sr.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }
}
