package com.example.day04.practice;

public class Practice4 {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};
        // 일반 for문
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //for-each문
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
