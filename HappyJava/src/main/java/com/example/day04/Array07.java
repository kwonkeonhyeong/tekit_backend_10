package com.example.day04;

public class Array07 {
    public static void main(String[] args) {
        int[][] iarr = new int[3][2];
        iarr[0][1] = 10;

        int[][] iarr2 = new int[3][]; // 이렇게 만들면 iarr2는 int값이 아니라 int[]의 메모리 주소를 저장하는 배열이 생성된다.
        // iarr2[0][0] = 10; // 이차원 배열을 비워둔채 생성하고 사용하려하면 NullPointerException 발생

        iarr2[0] = new int[3];

        iarr2[0][0] = 10; // NullPointerException 해결

        int[][][] iarr3 = new int[3][][];
    }
}
