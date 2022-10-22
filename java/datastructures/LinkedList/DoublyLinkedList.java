package datastructures.LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    private class Node {
        int element;
        Node next;
        Node prev;

        public Node(int element, Node next, Node prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(int element){
        Node tmp = new Node(element, head, null);
        if(head != null){
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null){
            tail = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void addLast(int element){
        Node tmp = new Node(element, null, tail);
        if(tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if(head == null){
            head = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void traverseForward() {
        System.out.println("Traversing forward..");
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void traverseBackWard() {
        System.out.println("Traversing backward..");
        Node tmp = tail;
        while (tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    public int removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    public int removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addLast(56);
        dll.addLast(364);
        dll.traverseForward();
        dll.removeFirst();
        dll.removeLast();
        dll.traverseBackWard();
        
    }

}
