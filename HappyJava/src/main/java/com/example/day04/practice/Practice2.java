package com.example.day04.practice;

public class Practice2 {
    public static void main(String[] args) {
        double[] doubles = {1.0, 2.5, 3.7, 4.4};

        // 일반 for문
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }

        // for-each 사용해보기
        for (double d : doubles) {
            System.out.println(d);
        }
    }
}
