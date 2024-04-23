package com.example.babylion.io;

import java.time.LocalDateTime;

public class Exam03 {
    public static void main(String[] args) {
        MyTimer timer1 = new MyTimer("timer1",3);
        MyTimer timer2 = new MyTimer("timer2",2);
        MyTimer timer3 = new MyTimer("timer3",4);
        timer1.start();
        timer2.start();
        timer3.start();
    }
}

class MyTimer extends Thread {
    private final String name;
    private final int second;

    public MyTimer(String name, int second) {
        this.name = name;
        this.second = second;
    }

    @Override
    public void run() {
        System.out.println(name + " 시작 : " + LocalDateTime.now());
        for (int i = 0; i < second; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " 끝 : " + LocalDateTime.now());
    }
}
