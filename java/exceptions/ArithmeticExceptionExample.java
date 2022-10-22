package exceptions;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try{
            int a = 12 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
