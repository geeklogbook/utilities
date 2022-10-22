package exceptions;

public class CloneException {
    String name;

    CloneException(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        try{
            CloneException expOne = new CloneException("CloneException");
            CloneException expTwo = (CloneException) expOne.clone();

            System.out.println(expTwo);
        } catch (CloneNotSupportedException c) {
            c.printStackTrace();
        }
    }
}
