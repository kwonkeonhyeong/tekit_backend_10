package com.example.day03.problemsAns;

import java.util.Scanner;

public class IfExam05 {
    /*
     * 두 개의 실수를 입력받아 모두 4.0 이상이면 "A",
     * 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.


    입력예 : 4.3 3.5
    출력예 :B

    입력예 : 4.0 2.9
    출력예 :C

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("두개의 실수를 입력해주세요: ");
        double i = scanner.nextDouble();
        double j = scanner.nextDouble();

        if (i >= 4.0 && j >= 4.0) {
            System.out.println("A");
        } else if (i >= 3.0 && j >= 3.0) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
}
