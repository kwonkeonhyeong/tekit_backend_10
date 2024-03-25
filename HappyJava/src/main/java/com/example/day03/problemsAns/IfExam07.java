package com.example.day03.problemsAns;

import java.util.Scanner;

public class IfExam07 {
    /*
     * 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을
     * 출력하는 프로그램을 작성하시오.


    입력예:18 -5 10
    출력예:-5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3개의 정수를 입력해주세요: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int result;

        result = Math.min(a,b);
        result = Math.min(result,c);

        System.out.println(result);
    }
}
