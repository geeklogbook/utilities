package datastructures.Arrays;

import java.util.Arrays;

public class DynamicArray {
    private int array[];
    private int size;
    private int capacity;

    public DynamicArray(){
        array = new int[2];
        size = 0;
        capacity = 2;
    }

    public void addElement(int element){
        if(size == capacity){
            ensureCapacity(2);
        }
        array[size] = element;
        size++;
    }

    public void addElement(int index, int element){
        if(size == capacity){
            ensureCapacity(2);
        }

        for(int i = size - 1; i > index; i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void remove(int index){
        if(index >= size || index < 0){
            System.out.println("No element at this index");
        } else {
            for(int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            array[size-1] = 0;
            size--;
        }
    }

    public void ensureCapacity(int minCapacity){
        int temp[] = new int[capacity * minCapacity];
        for (int i = 0; i < capacity; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }

    public void trimToSize(){
        System.out.println("Trimming the array");
        int temp[] = new int[size];
        for(int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public void printElements(){
        System.out.println("element in array are :" + Arrays.toString(array));
    }


}
