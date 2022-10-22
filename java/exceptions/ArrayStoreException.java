package exceptions;

public class ArrayStoreException {

    public static void main(String[] args) {
        try{
            Object sampleArray[] = new Integer[3];
            sampleArray[0] = new String("a");
        }
        catch (java.lang.ArrayStoreException e){
            e.printStackTrace();
        }
    }
}
