package com.example.day12;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferedExam {
    public static void main(String[] args) {
        //키보드(System.in)로부터 여러 줄 입력 받아서 파일에 출력하는 프로그램을 작성해보세요.
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter("output.txt");
        ) {
            String userInput = null;

            while (true) {
                System.out.println("문자열을 입력해주세요: ");
                userInput = reader.readLine();
                if (userInput.equals("")) {
                    break;
                }
                writer.println(userInput);
            };
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
