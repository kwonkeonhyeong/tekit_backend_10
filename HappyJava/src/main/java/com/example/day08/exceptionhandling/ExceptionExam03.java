package com.example.day08.exceptionhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExam03 {
    public static void main(String[] args) throws FileNotFoundException {
        // 예외 종류 2가지
        // 실행 시 발생하는 예외 (Runtime exception)
        // 컴파일 시 체크하는 예외. (checked Exception)

        // 예외 처리방법 2가지
        // 1. try-catch 으로 처리하는 방법
        // 2. throws 하는 방법
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("abc.txt");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

        int[] iarr = null;
        iarr[0] = 10;
    }
}
