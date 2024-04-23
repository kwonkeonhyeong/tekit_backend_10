package com.example.babylion.io;

public class ThreadExam01 {
    public static void main(String[] args) {
        System.out.println("main 시작!!");
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println("main 끝!!!");
    }
}
//1. Thread 상속!!
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("스레드에서 실제 하고자 하는 일 구현!!");
    }
}

// 2. Runnable 상속!!

