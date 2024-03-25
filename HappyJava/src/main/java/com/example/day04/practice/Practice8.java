package com.example.day04.practice;

public class Practice8 {
    public static void main(String[] args) {
        int[] scores = {70, 85, 90, 45, 100};
        int sum = 0;
        for (int score : scores) {
            sum+=score;
        }
        double average = (double) sum/scores.length;

        System.out.println(String.format("%.2f",average));
    }
}