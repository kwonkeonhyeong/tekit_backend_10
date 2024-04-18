package com.example.day13.exam1;

public class DecrementCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("Decrement: " + i);
        }
    }
}
