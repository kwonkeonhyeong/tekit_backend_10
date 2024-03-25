package com.example.day04;

public class ArrayExam1 {
    public static void main(String[] args) {
        // 선언
        int[] iarr;

        int iarr2[];

        // 생성
        iarr = new int[3];
        iarr2 = new int[5];

        // 이용
        iarr[0] = 10;
        iarr[1] = 20;

        int i = iarr[0];

        System.out.println(i);
        System.out.println(iarr[0]);

        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        // iarr[3] = 40;
    }
}
