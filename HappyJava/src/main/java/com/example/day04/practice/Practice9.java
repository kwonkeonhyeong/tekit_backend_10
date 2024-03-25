package com.example.day04.practice;

public class Practice9 {
    public static void main(String[] args) {
        String[] words = {"Java", "Python", "C", "JavaScript", "apple", "iphone"};

        String lastString = words[words.length-1];
        for (int i = words.length-1; i > 0; i--) {
            words[i] = words[i-1];
        }
        words[0] = lastString;

        for (String word : words) {
            System.out.print(word + "\t");
        }
    }
}
