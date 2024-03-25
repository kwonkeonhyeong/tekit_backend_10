package com.example.day02;

public class WhileTest {
    public static void main(String[] args) {
        int height = 1;
        while(height <= 100) {
            int a = 1;
            while(a <= height) {
                System.out.print("*");
                a++;
            }
            System.out.println();
            height++;
        }
    }
}
