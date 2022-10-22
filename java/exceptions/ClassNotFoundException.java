package exceptions;

public class ClassNotFoundException {
    public static void main(String[] args) {
        try{
            Class.forName("example.busqueda.claseInexistente");
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
