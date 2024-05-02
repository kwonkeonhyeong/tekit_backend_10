package com.example.day17.exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class exam2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple","banana","cherry","date");

        List<String> filteredWords = words.stream().filter(x -> x.length() >= 5).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(filteredWords);
    }
}
