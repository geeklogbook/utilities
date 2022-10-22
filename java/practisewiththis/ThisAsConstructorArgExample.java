package practisewiththis;

public class ThisAsConstructorArgExample {
    SupportingClass obj;

    ThisAsConstructorArgExample(SupportingClass obj){
        this.obj = obj;

        obj.display();
    }

}

class SupportingClass{
    String str = "foo";

    SupportingClass(){
        ThisAsConstructorArgExample obj = new ThisAsConstructorArgExample(this);
    }

    void display(){
        System.out.println("Value of supporting class: " + str);
    }

    public static void main(String[] arg){
        SupportingClass obj = new SupportingClass();
    }
}
