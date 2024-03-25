package com.example.day5.main;

import com.example.day5.util.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(3,1));
        System.out.println(calculator.minus(3,1));
    }
}
