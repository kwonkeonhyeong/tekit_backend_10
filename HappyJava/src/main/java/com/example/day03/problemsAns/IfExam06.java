package com.example.day03.problemsAns;

import java.util.Scanner;

public class IfExam06 {
    /*
     * 영문 대문자를 입력받아 'A'이면 “매우잘함”,
     * 'B'이면 “잘함”, 'C'이면 “보통임”,
     * 'D'이면 “노력요함”, 'F'이면 “낙제”,
     * 그 외 문자이면 “잘못입력”이라고 출력하는 프로그램을 작성하시오.
    입력예:B

    출력예:잘함
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자를 입력해주세요: ");
        String str = scanner.nextLine();

        if (str.equals("A")) {
            System.out.println("매우잘함");
        } else if (str.equals("B")) {
            System.out.println("잘함");
        } else if (str.equals("C")) {
            System.out.println("보통임");
        } else if (str.equals("D")) {
            System.out.println("노력요함");
        } else if (str.equals("F")) {
            System.out.println("낙제");
        } else {
            System.out.println("잘못입력");
        }
    }
}
