package com.example.day10.exam;

import java.util.List;

public class Output {
    public void printNotice() {
        System.out.println("0~100 사이의 숫자를 입력해주세요.");
    }

    public <T> void printResult(List<T> resultList) {
        for (T result : resultList) {
            System.out.print(result.toString());
        }
    }
}
