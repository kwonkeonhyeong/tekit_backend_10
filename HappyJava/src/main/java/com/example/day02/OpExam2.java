package com.example.day02;

public class OpExam2 {
    public static void main(String[] args) {
        int a = 5;
        ++a; // a = a + 1, a += 1

        System.out.println(a++);
        System.out.println(a);

        int b = 10;
        System.out.println(b + 4); // 출력 시에 자체 값을 변경하지는 않음
        System.out.println(b);
    }
}
