package practisewiththis;

public class ThisKeywordVariableExample {

    private String description;

    public void printDescription(String description){
        this.description = "bar";
        System.out.println("The value of local method is " + description);
        System.out.println("The value of instance variable is " + this.description);
    }

    public static void main(String[] args) {
        ThisKeywordVariableExample obj = new ThisKeywordVariableExample();
        obj.printDescription("foo");
    }
}
