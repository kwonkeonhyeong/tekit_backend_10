package com.example.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam1 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a", "b", "c", "d", "e", "apple", "amazing");

        List<String> filteredList = myList.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(filteredList);

        // 스트림 쓰지 않고 코드를 만든다면??
        List<String> result = new ArrayList<>();
        for (String str : myList) {
            if (str.startsWith("a")) {
                result.add(str);
            }
        }
        System.out.println(result);

        String[] names = {"kang", "kim", "hong", "lee", "son"};
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("=============================");
        Arrays.stream(names).forEach(System.out::println);
        System.out.println("=============================");
        Arrays.stream(names).forEach(name -> System.out.println(name));
        System.out.println("=============================");
        Arrays.stream(names).forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

        Integer[] iarr = {1,2,3,4,5,6,7,8};
        for (int i : iarr) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }

        Arrays.stream(iarr).filter(x -> x % 2 == 0).forEach(System.out::println);
    }

}
