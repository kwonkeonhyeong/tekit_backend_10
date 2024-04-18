package com.example.day13;

public class JoinExam {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException e) {}
        System.out.println("SumThread에서 계산한 결과는 :    입니다.");
    }
}

class SumThread extends Thread {
    @Override
    public void run() {
        System.out.println("계산 종료!!");
    }
}
