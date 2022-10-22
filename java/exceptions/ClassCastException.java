package exceptions;

public class ClassCastException {
    public static void main(String[] args) {
        try {
            Object newObject = new Integer(0);
            System.out.println((String)newObject);
        } catch (java.lang.ClassCastException e) {
            e.printStackTrace();
        }
    }

}
