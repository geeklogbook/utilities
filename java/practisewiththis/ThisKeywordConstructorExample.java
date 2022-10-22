package practisewiththis;

public class ThisKeywordConstructorExample {

    String a;
    String b;

    ThisKeywordConstructorExample(){
        this("foo", "bar");
        System.out.println("Inside no arguent constructor");
    }

    ThisKeywordConstructorExample(String a, String b){
        this.a = a;
        this.b = b;
        System.out.println("Inside parametrized constructor: "+a+" "+b);
    }

    public static void main(String[] args) {
        ThisKeywordConstructorExample obj = new ThisKeywordConstructorExample();
    }

}
