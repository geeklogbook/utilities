package algorithms.Insertion;

import java.util.ArrayList;

public class Insertion {

    public static void insertionSort(ArrayList<Integer> arr, int n){
        int i, j, newValue;

        for(i = 1; i < n; i++){
            newValue = arr.get(i);
            j = i;

            while (j > 0 && arr.get(j - 1) > newValue){
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, newValue);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> insertNumbers = new ArrayList<Integer>();;

        for (int i = 0; i < 10; i++){
            int number = (int) Math.round(Math.random() * 100) % 100;
            System.out.println("Number: " + number);
            insertionSort(insertNumbers, number);
        }

        insertionSort(insertNumbers, 8);
        insertionSort(insertNumbers, 3);
        insertionSort(insertNumbers, 2);


    }
}
