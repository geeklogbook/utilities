package exceptions;

public class NegativeArraySizeException {
    public static void main(String[] args) {
        try {
            int[] sampleArray = new int[-1];
        } catch (java.lang.NegativeArraySizeException e){
            e.printStackTrace();
        }
    }

}
