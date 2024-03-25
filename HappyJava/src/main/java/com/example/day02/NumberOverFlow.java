package com.example.day02;

public class NumberOverFlow {
    public static void main(String[] args) {
        int value = 10;
        int maxInt = Integer.MAX_VALUE;

        System.out.println(value + 1);
        System.out.println(maxInt);
        System.out.println(maxInt + 1);
    }
}
