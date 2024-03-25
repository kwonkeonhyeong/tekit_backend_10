package com.example.day04.practice;

public class Practice3 {
    public static void main(String[] args) {
        String[] words = {"Hello", "World", "Java", "Programing"};
        // 일반 for문
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        //for-each문
        for (String word : words) {
            System.out.println(word);
        }
    }
}
