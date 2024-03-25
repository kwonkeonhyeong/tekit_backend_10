package com.example.day03.problemsAns;

import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        System.out.println("실습 문제 5: 숫자 맞추기 게임");
        Scanner scanner = new Scanner(System.in);

        int random = (int) (Math.random() * 100) + 1;
        System.out.println(random);

        System.out.println("숫자를 입력해주세요: ");
        int n = scanner.nextInt();

        while (n != random) {
            if (n > random) {
                System.out.println("정답보다 입력값이 큽니다.");
            } else if (n < random) {
                System.out.println("정답보다 입력값이 작습니다.");
            }
            System.out.println("숫자를 입력해주세요: ");
            n = scanner.nextInt();
        }
        System.out.println("정답입니다.");
    }
}
