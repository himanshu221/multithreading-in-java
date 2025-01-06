package MonitorLockEx;

public class SharedResource {
    private boolean itemAvailable = false;

    synchronized public void addItem(){
        System.out.println("Inside add item");
        itemAvailable = true;
        notifyAll();
        System.out.println("Item is available");
    }

    synchronized public void consumeItem(){
        System.out.println("Inside consume item");
        while(!itemAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed item");
        itemAvailable = false;
    }
}
