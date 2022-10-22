package practisewiththis;

public class ThisAsMethodParamExample {

    public void printClassInstance(ThisAsMethodParamExample obj){
        System.out.println("Runtime class of the object = "+obj.getClass());
    }

    public void passObjectInstance(){
        printClassInstance(this);
    }

    public static void main(String[] args){
        ThisAsMethodParamExample thisAsMethodParamExample = new ThisAsMethodParamExample();
        thisAsMethodParamExample.passObjectInstance();
    }



}
