package datastructures.Queue;

import java.util.Arrays;

public class CircularQueue {

    private int currentSize;
    private int[] circularQueueElements;
    private int maxSize;

    private int rear;
    private int front;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = new int[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    public void enqueue(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Circular queue is full. Element cannot be added");
        } else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;

            if(front == -1){
                front = rear;
            }
        }
    }


    public int dequeue() throws Exception {
        int deQueuedElement;
        if(isEmpty()){
            throw new Exception("Circular Queue is empty. Element cannot be retrieved");
        } else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = Integer.MIN_VALUE;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    public boolean isFull(){
        return (currentSize == circularQueueElements.length);
    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }

    @Override
    public String toString(){
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Implementing Circcular Queue");
        CircularQueue circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full circular Queue " + circularQueue);

        System.out.print("Dequeued following element from circular Queue");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("After enqueuing circular queue with element having value 23");
        System.out.println(circularQueue);
    }

}
