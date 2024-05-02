package com.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamExam3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");
        // 클자수가 5 이상인 것만 필터링하고, 중복은 제거해서 새로운 리스트로 얻어온다.
        List<String> filteredWords =  words.stream().filter(x -> x.length() >= 5).distinct().collect(Collectors.toList());
        System.out.println(filteredWords);

        words.stream().map(word -> word.toUpperCase()).forEach(System.out::println);

        int[] intArr = {3,5,3,76,4,2};
        Arrays.stream(intArr).map(i -> i * 3).forEach(System.out::println);
        System.out.println("=====================");
        Arrays.stream(intArr).filter(i -> i % 2 == 0).map(i -> i * 3).forEach(System.out::println);
    }
}
