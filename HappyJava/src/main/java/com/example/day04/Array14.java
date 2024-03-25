package com.example.day04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array14 {
    public static void main(String[] args) {
        int[] copyFrom = {1,2,3};

        int[] copyTo = Arrays.copyOf(copyFrom, copyFrom.length);

        for (int c : copyTo) {
            System.out.println(c);
        }

        System.out.println("----------------------");
        int[] copyTo2 = Arrays.copyOf(copyFrom,5);
        for (int c : copyTo2) {
            System.out.println(c);
        }

        System.out.println("----------------------");
        char[] copyFrom2 = {'h','e','l','l','o','!'};
        char[] copyTo3 = Arrays.copyOfRange(copyFrom2,1,3);

        for (char c : copyTo3) {
            System.out.println(c);
        }

        System.out.println("----------------------");
        int[] array1 = {1,2,3,4,5};
//        int[] array2 = {1,2,3,4,5};
         int[] array2 = {1,2,3,5,1};
//         int[] array2 = {1,2,3,4,4};

        // 두 값이 똑같으면 0, 앞에 있는 배열이 더 크면 1, 뒤에 있는 배열이 더크면 -1
        int compare = Arrays.compare(array1,array2);
        System.out.println(compare);
    }
}
