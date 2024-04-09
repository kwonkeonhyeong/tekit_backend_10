package com.example.day07.interfaceExam;

interface Calculator {
    static int add(int a, int b) {
        return a + b;
    };
    int minus(int a, int b);

    static void light() {
        System.out.println("불을 밝히다.");
    }
}
