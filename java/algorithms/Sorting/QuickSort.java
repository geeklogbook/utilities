package algorithms.Sorting;

public class QuickSort {

    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if  (arr[j] < pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int arr[], int low, int high){
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

        }
    }

    static void display(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        System.out.println("before");
        display(arr);
        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n - 1);

        System.out.println("after");
        display(arr);
    }

}
