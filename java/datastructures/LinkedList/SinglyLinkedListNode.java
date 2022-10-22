package datastructures.LinkedList;

public class SinglyLinkedListNode {
    protected int data;
    protected SinglyLinkedListNode next;


    protected SinglyLinkedListNode(){
        next = null;
        data = 0;
    }

    public SinglyLinkedListNode(int d, SinglyLinkedListNode n){
        next = n;
    }

    public void setLinkNext(SinglyLinkedListNode n){
        next = n;
    }

    public SinglyLinkedListNode getLinkNext(){
        return next;
    }

    public void setData(int d){
        data = d;
    }

    public int getData(){
        return data;
    }
}
