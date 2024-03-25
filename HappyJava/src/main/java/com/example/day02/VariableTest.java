package com.example.day02;

public class VariableTest {
    public static void main(String[] args) {
        sum();
        literal();
        print();
    }
    public static void sum() {
        int a = 10;
        int b = 20;
        int c = 30;
        int sum = a+b+c;
        System.out.println(sum);
    }

    public static void literal() {
        String str=  "hello";
        int a = 10;
        boolean yes = true;
        float f = 0f;
    }

    public static void print() {
        int x = 1;
        System.out.println(x);
        System.out.println(x*2);
    }
}
