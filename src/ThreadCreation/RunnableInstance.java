package ThreadCreation;

public class RunnableInstance implements Runnable{

    @Override
    public void run(){
        System.out.println("Runnable Instance run invoked : " + Thread.currentThread().getName());
    }
}
