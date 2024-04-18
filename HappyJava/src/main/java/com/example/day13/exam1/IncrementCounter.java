package com.example.day13.exam1;

public class IncrementCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){}
            System.out.println("Increment: " + (i+1));
        }
    }
}
