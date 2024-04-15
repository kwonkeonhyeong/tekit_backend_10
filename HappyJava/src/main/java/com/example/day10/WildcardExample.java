package com.example.day10;

import java.util.Arrays;
import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    public static<T> void printList2(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3);
        List<String> stringList = Arrays.asList("hello","world");
        List<Double> doubleList = Arrays.asList(1.1,2.2,3.3);

        printList(intList);
        printList(stringList);
        printList(doubleList);
    }
}
