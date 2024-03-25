package com.example.day04;

public class Array02 {
    public static void main(String[] args) {
        int[] array1, array2;
        int array3[], array4;

        array2 = new int[2];
        array4 = 10;

        int[] iia = new int[4];

        iia[0] = 19;

        int[] arr2 = new int[]{10,20,30};
        int[] arr3 = {10,20,30,40};

        System.out.println(arr2[2]);
        System.out.println(arr3[3]);

        // 반복문
        for (int i = 0; i < 4; i++) {
            iia[i] = i+i;
        }

        for (int i : iia) {
            System.out.println(i);
        }

        for (int j = 0; j < iia.length; j++) {
            System.out.println(iia[j]);
        }
    }
}
