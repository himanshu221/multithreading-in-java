package Semaphores;

public class Main {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(2);

        new Thread(sharedResource::task).start();
        new Thread(sharedResource::task).start();
        new Thread(sharedResource::task).start();
        new Thread(sharedResource::task).start();
    }
}
