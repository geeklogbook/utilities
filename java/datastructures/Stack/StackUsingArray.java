package datastructures.Stack;

import java.util.EmptyStackException;

public class StackUsingArray {

    private int arr[];
    private int size;
    private int index = 0;

    public StackUsingArray(int size){
        this.size = size;
        arr = new int[size];
    }

    public void push(int element){
        if(isFull()){
            throw new StackOverflowError("Stack is full");
        }

        arr[index] = element;
        index++;
    }

    public int pop() {

        if(isEmpty()){
            throw new EmptyStackException();
        }
        int peekIndex = index - 1;
        return arr[--index];
    }

    public int peek(){

        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int peekIndex = index - 1;
        return arr[peekIndex];
    }

    public boolean isEmpty(){
        if(index == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(index == size){
            return true;
        }
        return false;
    }

    public int size(){
        return index;
    }

    public static void main(String[] args) {
        System.out.println("Implementation of stack ADT using arrays");
        StackUsingArray stack = new StackUsingArray(5);
        System.out.println("1. Push element");
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2. Size: " + stack.size());
        System.out.println("3. Peek: " + stack.peek());

        System.out.print("4. Pop: ");
        while(!stack.isEmpty()){
            System.out.printf(" %d", stack.pop());
        }

        System.out.println("\n. Size of a stack after pop operations: " + stack.size());
    }
}
