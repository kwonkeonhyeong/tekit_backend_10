package com.example.day13.javastandard;

public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadEx1_1 threadEx1_1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread threadEx1_2 = new Thread(r);

        threadEx1_1.start();
        threadEx1_2.start();
    }
}

class ThreadEx1_1 extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName());
        }
    }
}


class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}