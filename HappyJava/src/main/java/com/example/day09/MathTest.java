package com.example.day09;

public class MathTest {
    public static void main(String[] args) {
        int maxNumber = Math.max(10, 20);
        int minNumber = Math.min(10, 20);
        double squareRoot = Math.sqrt(16);
        double power = Math.pow(2, 3);

        System.out.println("maxNumber = " + maxNumber);
        System.out.println("minNumber = " + minNumber);
        System.out.println("squareRoot = " + squareRoot);
        System.out.println("power = " + power);

        double randomValue = Math.random();
        System.out.println("randomValue = " + randomValue);
    }
}
