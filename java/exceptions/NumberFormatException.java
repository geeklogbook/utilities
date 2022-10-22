package exceptions;

public class NumberFormatException {
    public static void main(String args[]){
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
