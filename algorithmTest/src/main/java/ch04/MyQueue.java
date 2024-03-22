package ch04;

public class MyQueue {
    private int maxSize;
    private int enqueuePointer;
    private int dequeuePointer;
    private int[] queueArray;

    public MyQueue(int queueSize) {
        this.maxSize = queueSize;
        this.queueArray = new int[maxSize];
        this.enqueuePointer = 0;
        this.dequeuePointer = 0;
    }

    public void enqueue(int value) {
        if(!isFull()) {
            queueArray[enqueuePointer] = value;
            enqueuePointer++;
        } else {
            System.out.println("큐가 가득 찼습니다.");
        }
    }

    public int dequeue() {
        if(!isEmpty()) {
            return queueArray[dequeuePointer++];
        } else {
            System.out.println("큐가 비어있습니다.");
            return -1;
        }
    }

    public int peek() {
        return queueArray[dequeuePointer];
    }

    public boolean isEmpty() {
        return enqueuePointer <= dequeuePointer;
    }

    public boolean isFull() {
        return enqueuePointer == maxSize;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
