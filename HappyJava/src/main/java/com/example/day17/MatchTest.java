package com.example.day17;

import java.util.Arrays;

public class MatchTest {
    public static void main(String[] args) {
        int[] intArr = {2,4,6,8};

        System.out.println("모두 3의 배수 입니까???");
        System.out.println(Arrays.stream(intArr).allMatch(x -> x%3 == 0));
        System.out.println("3의 배수를 가지고 있습니까???");
        System.out.println(Arrays.stream(intArr).anyMatch(x -> x%3 == 0));
        System.out.println("모두 3의 배수가 아닙니까???");
        System.out.println(Arrays.stream(intArr).noneMatch(x -> x%3 == 0));
    }
}
