package com.example.day13;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyTread 출발");
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread안녕" + i);
        }
        System.out.println("MyThread종료!!!");
    }
}

class MongThread extends Thread {
    @Override
    public void run() {
        System.out.println("MongThread 출발");
        for (int i = 0; i < 10; i++) {
            System.out.println("MongThread 안녕" + i);
        }
        System.out.println("MongThread 종료!!!");
    }
}

public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("main 출발!!");

        // 쓰레드 생성.
        MyThread myThread = new MyThread();
        myThread.start();

        MongThread mongThread = new MongThread();
        mongThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main 안녕!!!");
        }
        System.out.println("main 종료!!!");
    }
}
