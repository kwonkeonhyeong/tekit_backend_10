package com.example.day03.problemsAns;

import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        System.out.println("실습 문제 4: 팩토리얼 계산기");
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요: ");
        int n = scanner.nextInt();
        int result = 1;
        for (int i = 1; i < n+1; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
