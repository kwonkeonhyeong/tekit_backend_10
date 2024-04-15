package com.example.day10;

public class GenericMethodExample {
    public static <T> void printArrayElements(T[] array){
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] iarray = {1,2,3,4,5,6};
        printArrayElements(iarray);

        String[] strArray = {"one", "two", "three", "four", "five"};
        printArrayElements(strArray);
    }
}
