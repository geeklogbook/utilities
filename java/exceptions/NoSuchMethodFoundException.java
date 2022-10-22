package exceptions;

public class NoSuchMethodFoundException {
    public static void main(String[] args) {
        try {
            String propertyName = "getAge";
            SampleClass.class.getDeclaredMethod(propertyName);
        } catch (java.lang.NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class SampleMethodClass {
    int age;

    SampleMethodClass(int age){
        age = age;
    }
}