package com.example.day17.exam;

import java.util.Arrays;
import java.util.stream.IntStream;

public class exam1 {
    public static void main(String[] args) {
        int[] numbers = {3,10,4,17,6};

        // 풀이 1
        int sum = Arrays.stream(numbers).filter(x -> x%2==0).sum();
        System.out.println(sum);

        // 풀이 2
        int sum2 = IntStream.of(numbers).filter(x -> x%2 == 0).reduce(0,(a,b) -> a+b);
        System.out.println(sum2);

        // 풀이 3
        int sum3 = Arrays.stream(numbers).filter(x -> x%2 == 0).reduce(Integer::sum).getAsInt();
        System.out.println(sum3);

        // 풀이 4
        int sum4 = Arrays.stream(numbers).filter(x -> x%2 == 0).reduce(0, Integer::sum);
        System.out.println(sum4);
    }
}
