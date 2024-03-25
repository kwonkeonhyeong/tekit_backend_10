package com.example.day03.problemsAns;

public class problem3 {
    public static void main(String[] args) {
        System.out.println("실습 문제 3: 구구단 출력기");

        int k = 2;
        while(k<10) {
            int i = 1;
            while(i<10) {
                System.out.printf("%d * %d = %d\t",k,i,k*i);
                i++;
            }
            System.out.println();
            k++;
        }
    }
}
