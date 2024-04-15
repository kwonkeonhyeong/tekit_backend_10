package com.example.day08.exceptionhandling;

import java.util.Scanner;

public class ExceptionExam07 {
    public void inputScore(int score) {
        if(score < 0 || score > 100) {
//            System.out.println("점수는 0-100 사이만 입력할 수 있습니다.");
//            return;
            throw new MyException("1-5점까지만 입력 가능합니다.");
        }
        System.out.println(score);
    }

    public static void main(String[] args) {
        ExceptionExam07 exceptionExam07 = new ExceptionExam07();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("점수를 입력하세요.");
        try {
            exceptionExam07.inputScore(keyboard.nextInt());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            // catch 블럭에서 아무일도 하지 않는 것이 가장 나쁜 예회처리...
        }

        System.out.println("main 종료!!");
    }
}
