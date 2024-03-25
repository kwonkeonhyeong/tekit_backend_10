package com.example.day02;

import com.example.day01.Book;

public class OpExam3 {
    public static void main(String[] args) {
        // 조건식 ? 반환값1 : 반환값2
        int a = 10;
        int b = 20;
        int result = a > b ? a : b;
        System.out.println(result);

        Book book = new Book();
        if(book instanceof Object) {
            System.out.println("Book은 객체입니다.");

        }
    }
}
