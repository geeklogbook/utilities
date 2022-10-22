package exceptions;

import java.util.Arrays;
import java.util.List;

public class UnsupportedOperationException {
    public static void main(String[] args) {
            String[] flowersAsArrays = {"String1","String2","String3","String4"};
            List<String> flowersAsArrayList = Arrays.asList(flowersAsArrays);
         try {
            flowersAsArrayList.add("String5");
        } catch (java.lang.UnsupportedOperationException e) {
        e.printStackTrace();
        }
    }
}
