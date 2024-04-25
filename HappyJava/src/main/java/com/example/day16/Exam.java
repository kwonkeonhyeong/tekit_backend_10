package com.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exam {
    public static void main(String[] args) {
        // 문제 1: 문자열 리스트 정렬하기
        List<String> foods = Arrays.asList("짜장면", "카레", "오므라이스", "부대찌개");
        Collections.sort(foods, (String a, String b) -> b.length() - a.length());
        System.out.println(foods);

        // 문제 2: 최대값 찾기
        Integer[] numbers = {1, 6, 3, 1, 2, 9, 7};
        Arrays.sort(numbers, Integer::compare);
        System.out.println(numbers[numbers.length - 1]);

        // 문제 3: 리스트의 각 요소에 연산 적용하기
        List<Integer> number2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ArrayList<>();
        number2.forEach(number -> result.add(number + 10));
        System.out.println(result);
    }
}
