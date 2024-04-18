package com.example.day13;

class MyRunnable implements Runnable {
    // MyRunnable은 Thread는 아니다.
    @Override
    public void run() {
        System.out.println("MyRunnable 출발");
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable 안녕" + i);
        }
        System.out.println("MyRunnable 종료!!!");
    }
}

class MongRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MongRunnable 출발");
        for (int i = 0; i < 10; i++) {
            System.out.println("MongRunnable 안녕" + i);
        }
        System.out.println("MongRunnable 종료!!!");
    }
}

public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("main 출발!!");

        // 쓰레드 생성.
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread mongRunnableThread = new Thread(new MongRunnable());
        mongRunnableThread.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("main 안녕!!!");
        }
        System.out.println("main 종료!!!");
    }
}
