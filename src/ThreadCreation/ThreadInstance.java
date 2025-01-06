package ThreadCreation;

public class ThreadInstance extends Thread{

    @Override
    public void run(){
        System.out.println("Code execution started for " + Thread.currentThread().getName());
    }
}
