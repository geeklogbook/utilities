package exceptions;

public class StringIndexBoundException {
    public static void main(String[] args) {
        String sampleStr = "JavaCodeGeeks";
     try {
        System.out.println(sampleStr.charAt(100));
    } catch (java.lang.StringIndexOutOfBoundsException e) {
         e.printStackTrace();
     }
}}
