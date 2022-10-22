package datastructures.Trees;

public class BinarySearchTreeNode {
    BinarySearchTreeNode left, right;
    int data;

    public BinarySearchTreeNode(){
        left = null;
        right = null;
        data = 0;
    }

    public BinarySearchTreeNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinarySearchTreeNode n) {
        left = n;
    }

    public void setRight(BinarySearchTreeNode n) {
        right = n;
    }

    public BinarySearchTreeNode getLeft(){
        return left;
    }

    public BinarySearchTreeNode getRight(){
        return right;
    }

    public void setData(int d){
        data = d;
    }

    public int getData(){
        return data;
    }
}
