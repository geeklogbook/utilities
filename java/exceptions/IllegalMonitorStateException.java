package exceptions;

import java.util.concurrent.TimeUnit;

public class IllegalMonitorStateException {
    public static void main(String[] args){
        try{
            Utility.syncObject.wait();
        } catch (InterruptedException ex) {
            System.out.println("An interruptedException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class Utility {

    public final static Object syncObject = new Object();

    public static class HaltThread extends Thread {

        @Override
        public void run() {
            synchronized (syncObject) {
                try {
                    System.out.println("[HaltThread]: Waiting for another thread" + "to notify me...");
                    syncObject.wait();
                    System.out.println("[HaltThread]: Successfully notified");
                } catch (InterruptedException ex) {
                    System.out.println("[HaltThread]: An InterruptedException was caught: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }

        }

    }

    public static class StartingThread extends Thread {
        @Override
        public void run() {
            synchronized (syncObject) {
                try {
                    System.out.println("[StartingThread]: Sleeping for some time...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("[StartingThread]: woke up");

                    System.out.println("[StartingThread]: about to notify another thread...");
                    syncObject.notify();
                    System.out.println("[StartingThread]: Successsfully notified some other thread!");
                } catch (InterruptedException ex) {
                    System.out.println("[StartingThread]: An InterruptedException was caught: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }
}