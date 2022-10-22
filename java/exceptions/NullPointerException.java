package exceptions;

public class NullPointerException {
    public static void main(String[] args) {
        try {
            String abc = null;
            System.out.println(abc.toLowerCase());
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
        }
    }
}
