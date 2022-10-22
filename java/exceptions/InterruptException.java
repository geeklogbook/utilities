package exceptions;

public class InterruptException extends Thread{

    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                if(i == 7) {
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                System.err.println("Sleep is disturbed. " + e);
                e.printStackTrace();
            }
            System.out.println("Iteration: " + i);
        }
    }

    public static void main(String args[]){
        InterruptException exceptionOne = new InterruptException();
        exceptionOne.start();

        try {
            exceptionOne.join();
        } catch (InterruptedException e){
            System.err.println("Properly not joined with parent thread. " + e);
            e.printStackTrace();
        }
    }
}
