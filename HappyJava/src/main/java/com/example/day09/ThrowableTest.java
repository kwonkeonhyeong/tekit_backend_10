package com.example.day09;

public class ThrowableTest {
    public static void main(String[] args) {
        try {
            int result = 10/0;
        } catch (ArithmeticException e) {
            System.err.println("예외 발생: " + e.getMessage());
//            e.printStackTrace();
        }
    }
}
