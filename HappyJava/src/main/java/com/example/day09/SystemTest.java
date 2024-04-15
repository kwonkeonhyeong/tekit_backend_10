package com.example.day09;

public class SystemTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.println("수행시간: " + (endTime - startTime) + "ms");

        String pathVariable = System.getenv("PATH");
        System.out.println("pathVariable = " + pathVariable);

        int[] sourceArray = {1,2,3,4,5};
        int[] destArray = new int[5];

        System.arraycopy(sourceArray, 0 ,destArray, 0, sourceArray.length);
    }
}
