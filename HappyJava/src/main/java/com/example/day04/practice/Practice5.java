package com.example.day04.practice;

public class Practice5 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int n = 1;

        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {
                matrix[column][row] = n++;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
