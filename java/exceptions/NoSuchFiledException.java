package exceptions;

class SampleClass{
    int age;

    SampleClass(int age){
        age = age;
    }
}

public class NoSuchFiledException {
    public static void main(String[] args) {
        try {
            String propertyName = "name";
            SampleClass.class.getDeclaredField(propertyName);
        } catch (java.lang.NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
