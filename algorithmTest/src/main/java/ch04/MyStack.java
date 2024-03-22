package ch04;

public class MyStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int data) {
        if (!isFull()) {
            stackArray[++top] = data;
        } else {
            System.out.println("스텍이 가득 찼습니다");
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("스택이 비었습니다.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("스택이 비었습니다.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
