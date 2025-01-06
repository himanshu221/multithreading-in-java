package ProducerConsumerWithLocks;


import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(5, new ReentrantLock());

        Thread producerThread = new Thread(() -> {
            for(int i =0; i < 10; ++i){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedResource.produceItem(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i =0; i < 10; ++i){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int item = sharedResource.consumeItem();
                System.out.println("Consumed item : " + item);
            }
        });

        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main program is ending");
    }
}
