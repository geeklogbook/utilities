package exceptions;

public class ArrayIndexOutOfBondException {
    public static void main(String[] args) {
        int[] arr = new int[3];
        try {
            arr[10] = 12;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
