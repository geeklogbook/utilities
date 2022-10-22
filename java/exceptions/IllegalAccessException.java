package exceptions;

public class IllegalAccessException {
    public static void main(String[] args) throws InstantiationException, java.lang.IllegalAccessException {
        Class<?> classVar = ClassWithPrivateConstructor.class;
        ClassWithPrivateConstructor t = (ClassWithPrivateConstructor) classVar.newInstance();
        t.sampleMethod();
    }
}

class ClassWithPrivateConstructor{
    private ClassWithPrivateConstructor() {}

    public void sampleMethod() {
            System.out.println("Method 'sampleMethod' Called");
        }
    }

