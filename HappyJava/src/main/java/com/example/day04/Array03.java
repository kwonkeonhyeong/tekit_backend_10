package com.example.day04;

public class Array03 {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        array1[3] = 4;
        array1[4] = 5;
        int[] array2 = new int[]{10,20,30,40,50};
        int[] array3 = {100, 200, 300, 400, 500};

        System.out.println("array1의 값 출력");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        System.out.println("array2의 값 출력");
        for (int j = 0; j < array2.length; j++) {
            System.out.println(array2[j]);
        }

        System.out.println("array3의 값 출력");
        for (int k = 0; k < array3.length; k++) {
            System.out.println(array3[k]);
        }
    }
}
