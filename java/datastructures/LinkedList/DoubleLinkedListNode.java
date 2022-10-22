package datastructures.LinkedList;

public class DoubleLinkedListNode {
    protected int data;
    protected DoubleLinkedListNode prev, next;

    public DoubleLinkedListNode(){
        next = null;
        prev = null;
        data = 0;
    }

    public DoubleLinkedListNode(int d, DoubleLinkedListNode n, DoubleLinkedListNode p){
        data = d;
        next = n;
        prev = p;
    }

    public void setLinkNext(DoubleLinkedListNode n){
        next = n;
    }

    public void setLinPrev(DoubleLinkedListNode p){
        prev = p;
    }

    public DoubleLinkedListNode getLinkNext(){
        return next;
    }

    public DoubleLinkedListNode getLinkPrev(){
        return prev;
    }

    public void setData(int d){
        data = d;
    }

    public int getData(){
        return data;
    }
}
