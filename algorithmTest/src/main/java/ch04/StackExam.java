package ch04;

public class StackExam {
    private int[] stackArray; // 스택을 저장할 배열
    private int stackCapacity; // 스택의 최대 크기
    private int stackPointer; // 스택 포인터

    public StackExam(int maxSize) {
        stackPointer = 0;
        stackCapacity = maxSize;
        stackArray = new int[stackCapacity];
    }

    public void push(int value) {
        if (stackPointer >= stackCapacity) {
            System.out.println("스택이 가득 찼습니다.");
        }
        stackArray[stackPointer++] = value;
    }

    public int pop() {
        if(stackPointer <= 0) {
            System.out.println("스택이 비어있습니다.");
        }
        return stackArray[--stackPointer];
    }

    public int peek() {
        if(stackPointer <= 0) {
            System.out.println("스택이 비어있습니다.");
        }
        return stackArray[stackPointer - 1];
    }

    public boolean isEmpty() {
        return stackPointer == 0;
    }

    public static void main(String[] args) {
        StackExam stackExam = new StackExam(3);

        stackExam.push(1);
        stackExam.push(2);
        stackExam.push(3);
        System.out.println(stackExam.peek());
        System.out.println(stackExam.peek());
        System.out.println(stackExam.isEmpty());

        System.out.println(stackExam.pop());
        System.out.println(stackExam.pop());
        System.out.println(stackExam.pop());
        System.out.println(stackExam.isEmpty());
    }
}
