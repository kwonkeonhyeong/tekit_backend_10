package com.example.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOExam2 {
    public static void main(String[] args) throws Exception {
        // 키보드로부터 한줄씩 입력 받아서 콘솔에 출력하고 싶다.

        // 키보드 System.in
        // 한줄씩 읽기 위해서 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//        String str = br.readLine();

//        System.out.println(str);

        BufferedReader br2 = new BufferedReader(new FileReader("a.txt"));

        System.out.println(br2.readLine());
        System.out.println(br2.readLine());
        System.out.println(br2.readLine());
        System.out.println(br2.readLine());
        System.out.println(br2.readLine());
        System.out.println(br2.readLine());
    }
}
