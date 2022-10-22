package datastructures.Trees;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTreeUtil BinarySearchTreeUtil = new BinarySearchTreeUtil();

        System.out.println("Tree operations");
        int[] arr = {12, 9, 100, 0, 76, 54, 5, 7, 0};

        System.out.println("Inserting");

        for(int i = 0; i < arr.length; i++){
            System.out.println("Element to inserted: " + arr[i] + "\n");
            BinarySearchTreeUtil.insert(arr[i]);
        }

        System.out.println("Binary Tree after inserting");
        BinarySearchTreeUtil.printTree();

        System.out.println("Search");
        BinarySearchTreeUtil.search(100);

        System.out.println("Delete");
        BinarySearchTreeUtil.delete(100);

        System.out.println("Print");
        BinarySearchTreeUtil.printTree();
    }
}
