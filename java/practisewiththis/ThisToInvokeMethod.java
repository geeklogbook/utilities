package practisewiththis;

public class ThisToInvokeMethod {

    public void method1(){
        System.out.println("Method 1");
        this.method2();
    }

    public  void method2(){
        System.out.println("Method 2");
    }

    public static void main(String[] args) {
        ThisToInvokeMethod thisToInvokeMethod = new ThisToInvokeMethod();
        thisToInvokeMethod.method1();
    }
}
