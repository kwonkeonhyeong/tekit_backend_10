package com.example.day03;

import java.util.Scanner;

public class ForExam1 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("*");
//        }
//
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("최소값을 입력하세요 : ");
        int min = scanner.nextInt();

        System.out.print("최대값을 입력하세요 : ");
        int max = scanner.nextInt();

        int evenSum = 0;
        for (; min <= max; min++) {
            if(min%2 == 0){
                evenSum+=min;
            }
        }
        System.out.println(min + "부터 " + max + "사이에 있는 짝수의 합은 " +evenSum + "입니다.");
    }
}
