package ThreadCreation;

public class Main {
    public static void main(String[] args){
        System.out.println("Thread Creation through implementing runnable interface");
        RunnableInstance runObj = new RunnableInstance();
        Thread thread = new Thread(runObj);
        thread.start();
        System.out.println("Triggered thread start method");

        System.out.println("Thread Creation through extending Thread class");
        ThreadInstance threadInstance = new ThreadInstance();
        threadInstance.start();

    }
}
