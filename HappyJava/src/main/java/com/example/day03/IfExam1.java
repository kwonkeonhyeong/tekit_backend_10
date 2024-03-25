package com.example.day03;

public class IfExam1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        if(a > b) {
            System.out.println("a는 b보다 큽니다.");
        } else if (a < b) {
            System.out.println("b는 a보다 큽니다.");
        } else {
            System.out.println("a와 b는 같습니다.");
        }

        if(a%2 == 0) {
            System.out.println("a가 짝수입니다.");
        } else {
            System.out.println("a는 훌수입니다.");
        }
    }
}
