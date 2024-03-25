package com.example.day04.practice;

public class Practice6 {
    public static void main(String[] args) {
        int[] numbers = {3,6,9,12,15};

        for (int i = numbers.length; i > 0; i--) {
            System.out.print(numbers[i-1] + "\t");
        }
    }
}
