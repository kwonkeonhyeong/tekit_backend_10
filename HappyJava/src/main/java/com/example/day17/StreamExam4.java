package com.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam4 {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple","Banana"),
                Arrays.asList("Cherry","Date")
        );
        List<String> flattenedList = nestedList.stream() // 스트림 생성
                        .flatMap(x -> x.stream()) // 리스트를 평탄화
                        .collect(Collectors.toList()); // 결과 수집
        System.out.println(flattenedList);

        List<String> list = Arrays.asList("hello java!!","hi carami", "lambda stream");
        list.stream().flatMap(x -> Arrays.stream(x.split(" "))).forEach(System.out::println);

        List<String> list2 = Arrays.asList("1,3,5,5,6,4,3");
        list2.stream().flatMapToInt(data -> {
            String[] strArr = data.split(",");
            int[] intArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i].trim());
            }
            return Arrays.stream(intArr);
         }).forEach(System.out::println);
        System.out.println("==========================");
        list2.stream().flatMapToInt(data -> Arrays.stream(data.split(",")).mapToInt(str -> Integer.parseInt(str.trim()))).forEach(
                System.out::println);
    }
}
