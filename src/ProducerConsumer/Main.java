package ProducerConsumer;

public class Main {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(5);

        Thread producerThread = new Thread(() -> {
            for(int i =0; i < 10; ++i){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedResource.addItem(i);
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
    }
}
