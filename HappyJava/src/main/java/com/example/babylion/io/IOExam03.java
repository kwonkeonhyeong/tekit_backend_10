package com.example.babylion.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IOExam03 {
    public static void main(String[] args) {
        // 파일에서부터 한줄씩 읽어서 콘솔에 출력하는 코드
        try {
            BufferedReader br = new BufferedReader(new FileReader("ioexam.txt"));
            PrintWriter pw = new PrintWriter("ioexam2.txt");
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                pw.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
