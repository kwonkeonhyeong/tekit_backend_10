package com.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exam2 {
    public static void main(String[] args) {
        // 문제 4: 조건에 맞는 요소 찾기
        // 방법 1
        List<String> foods2 = Arrays.asList("짜장면", "카레", "오므라이스", "부대찌개", "샐러드파스타");
        Consumer<List<String>> searchFood = food -> {
            for (int i = 0; i < food.size(); i++) {
                if (food.get(i).length() >= 5) {
                    System.out.println(food.get(i));
                    break;
                }
            }
        };

        searchFood.accept(foods2);

        // 방법 2
        Predicate<String> checkLength = food -> food.length() >= 5;
        for (int i = 0; i < foods2.size(); i++) {
            if(checkLength.test(foods2.get(i))) {
                System.out.println(foods2.get(i));
                break;
            }
        }

        // 문제 5: 요소 변환하기
        List<Integer> number3 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> result2 = new ArrayList<>();

        Function<Integer, Integer> square = x -> x * x;
        for (Integer i : number3) {
            result2.add(square.apply(i));
        }
        System.out.println(result2);

        // 문제 6: 모든 요소에 대해 조건 확인하기
        List<Integer> number4 = Arrays.asList(1,2,3,4,5,6,7);
        Predicate<Integer> isEven = x -> x%2 == 0;
        for (Integer i : number4) {
            if (isEven.test(i)) {
                System.out.println(i);
            }
        }
    }
}
