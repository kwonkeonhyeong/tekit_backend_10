package com.example.day03.problemsAns;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        System.out.println("실습 문제 2: 짝수와 홀수 판별기");
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요: " );
        int num = scanner.nextInt();
        if(num%2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
    }
}
