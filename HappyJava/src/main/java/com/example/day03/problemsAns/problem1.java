package com.example.day03.problemsAns;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        System.out.println("실습 문제 1: 온도 변환기");
        Scanner scanner = new Scanner(System.in);
        System.out.print("섭씨 온도를 입력해주세요: " );
        int c = scanner.nextInt();
        System.out.println("변환한 화씨 온도는 " + (c * 9/5 + 32) + "도 입니다.");
    }
}
