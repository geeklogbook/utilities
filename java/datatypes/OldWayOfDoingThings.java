package datatypes;

public class OldWayOfDoingThings {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 10, 15, 20, 25, 30};

        int[] newArr = new int[arr.length - 1];

        System.out.println("Original array values: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        int removeEleFromIndex = 2;
        for(int j = 0, k =0; j < arr.length; j++){
            if(j == removeEleFromIndex)
                continue;

            newArr[k++] = arr[j];
        }
        System.out.println("After removing an element from the given index: ");
        for(int l = 0; l < newArr.length; l++){
            System.out.print(newArr[l] + " ");
        }
    }

}
