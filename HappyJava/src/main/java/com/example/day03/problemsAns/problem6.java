package com.example.day03.problemsAns;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        System.out.println("실습 문제 6: 양의 정수의 합 구하기");
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요: ");
        int n;
        int sum = 0;

        do {
            n = scanner.nextInt();
            sum += n;
        } while(n != 0);

        System.out.println("입력한 정수들의 총합은 " + sum + "입니다.");
    }
}
