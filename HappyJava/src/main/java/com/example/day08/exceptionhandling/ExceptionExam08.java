package com.example.day08.exceptionhandling;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionExam08 {
    public static void main(String[] args) {
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("abc");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//            fis.close();
//            } catch (IOException e) {
//                throw new RuntimeException();
//            }
//        }

        try(FileInputStream fis2 = new FileInputStream("abs")){
            // 처리할 로직..
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
