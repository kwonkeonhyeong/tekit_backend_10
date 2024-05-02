package com.example.day17;

import java.util.Arrays;
import java.util.List;

public class AggregateStreamExam {
    public static void main(String[] args) {
        int[] intArr = {12,36,53,35,66,57};

        int max = Arrays.stream(intArr).boxed().max(Integer::compareTo).orElse(0);
        double average = Arrays.stream(intArr).average().orElse(0.0);
        System.out.println(max);
        System.out.println(average);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        long count = numbers.stream().count();
        int max2 = numbers.stream().max(Integer::compareTo).orElse(0);
        int min = numbers.stream().min(Integer::compareTo).orElse(0);
        double average2 = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(count);
        System.out.println(max2);
        System.out.println(min);
        System.out.println(average2);
        System.out.println(sum);
    }
}
