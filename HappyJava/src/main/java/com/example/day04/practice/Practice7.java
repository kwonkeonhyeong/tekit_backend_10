package com.example.day04.practice;

public class Practice7 {
    public static void main(String[] args) {
        double[] doubles = {1.5, 3.7, 2.4, 9.8, 7.6, 3.4};
        double max = Integer.MIN_VALUE;
        double min= Integer.MAX_VALUE;

        for (double aDouble : doubles) {
            min = Math.min(min,aDouble);
            max = Math.max(max,aDouble);
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
