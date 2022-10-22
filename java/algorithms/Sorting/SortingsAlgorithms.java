package algorithms.Sorting;

import java.util.ArrayList;

public class SortingsAlgorithms {

    public static void shSort(ArrayList<Integer> arr, int n){
        for(int gap = n/2; gap > 0; gap/=2){
            for(int i = gap; i < n; i +=1){
                int temp = arr.get(i);
                int j;
                for(j = i; j >= gap && arr.get(j -gap) > temp; j -= gap)
                    arr.set(j, arr.get(j-gap));
                arr.set(j, temp);
            }
        }
    }

    public static void bubbleSort(int[] a) {
        boolean sorted = false;
        int temp;

        while(!sorted){
            sorted = true;
            for(int i = 0; i < a.length - 1; i++){
                if(a[i] > a[i+1]){
                    temp   = a[i];
                    a[i]   = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current <= array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++){
                if(array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }

            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);

    }
}
