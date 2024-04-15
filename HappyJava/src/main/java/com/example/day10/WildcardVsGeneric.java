package com.example.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardVsGeneric {
    public static void addNumber(List<?> list) {
        // list.add(1); // 이 코드는 컴파일 오류를 발생시킨다. 왜냐하면 ?는 알 수 없는 타입이므로 안전하지 않은 연산으로 간주된다.
    }

    public static<T> void addNumberGeneric(List<T> list, T element) {
        list.add(element); // 이 코드는 컴파일이 성공한다. T는 명확한 타입으로 가눚되먀, 메소드 호출 시점에서 타입이 결정된다.
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        addNumber(intList); // 유효하지 않은 작업
        addNumber(stringList); // 유효하지 않은 작업

        addNumberGeneric(intList, 10);
        addNumberGeneric(stringList, "Hello");

        System.out.println(intList);
        System.out.println(stringList);
    }
}
