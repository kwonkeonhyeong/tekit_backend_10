package ch04;

public class MyQueue2 {
    private int[] queueArray;
    private int front; // 큐의 맨 앞 값의 인덱스
    private int rear; // 큐 맨 뒤 값의 다음 인덱스
    private int capacity; // 큐 최대용량
    private int count; // 큐에 저장된 데이터의 수

    public MyQueue2(int capacity){
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void enqueue(int item) {
        if(count == capacity) {
            System.out.println("큐가 가득 찼어요.");
        } else {
            queueArray[rear] = item;
//            rear++; // 선형큐 이부분을 수정해서 원형 큐로 변환
            rear = (rear+1) % capacity;
            count++;
        }
    }

    public int dequeue() {
        if(count == 0) {
            System.out.println("큐가 비었어요.");
            return -1;
        } else {
            int item = queueArray[front];
            front = (front+1) % capacity;
            count--;
            return item;
        }
    }

    public int peek() {
        if(count == 0) {
            System.out.println("큐가 비었어요.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek()); // 2
    }
}
