package com.example.day07;

public class MyCalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new MyCalculator();
        System.out.println(calculator.multiple(1,2));
        System.out.println(calculator.plus(1,2));
        System.out.println(calculator.exec(1,2));

        ((MyCalculator) calculator).who();
        System.out.println(((MyCalculator) calculator).multiple(1,2));
        System.out.println(((MyCalculator) calculator).plus(1,2));
        System.out.println(((MyCalculator) calculator).exec(1,2));
    }
}
