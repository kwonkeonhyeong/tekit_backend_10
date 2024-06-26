package com.example.day03.problemsAns;

import java.util.Scanner;

public class IfExam03 {
    /*
     * 나이를 입력받아 20살 이상이면 “성인입니다.” 라고 출력하고 그렇지 않으면
     * “당신은 ○년 후에 성인이 됩니다.” 라는 메시지를 출력하는 프로그램을 작성하시오.

    입력예 : 18
    출력예 : 당신은 2년 후에 성인이 됩니다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("나이를 입력해주세요: ");
        int age = scanner.nextInt();

        if (age >= 20) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("당신은 " + (20-age) + "년 후에 성인이 됩니다.");
        }
    }
}
