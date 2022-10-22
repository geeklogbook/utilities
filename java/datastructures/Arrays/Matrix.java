package datastructures.Arrays;

public class Matrix {
    public static void main(String[] args) {
        System.out.println("Two dimensional array or matrix: ");
        int[][] arr = {{1,2},{3,4}};

        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                System.out.println("arr[" + i +"]["+ j + "] = " + arr[i][j]);
    }
}
