package datastructures.Arrays;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.addElement(1);
        array.addElement(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.addElement(3);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.addElement(1, 3);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.addElement(2, 6);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(1);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(1);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.trimToSize();
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.addElement(2);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();

        array.addElement(3);
        System.out.println("Size: " + array.size() + " and capacity: " + array.capacity());
        array.printElements();


    }
}
