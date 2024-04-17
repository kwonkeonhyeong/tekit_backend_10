package com.example.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.IIOException;

public class SystemIoExample {
    public static void main(String[] args) {
        //키보드(System.in)로부터 한 줄 입력 받기위한 IO객체를 생성해주세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("문자열을 입력하세요: ");
            String userInput = reader.readLine();

            System.out.println("입력받은 문자열: " + userInput);
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("리더를 닫는 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }
}
