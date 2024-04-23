package com.example.babylion.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam01 {
    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter("input.txt");
                ){
            String i;
            while(!(i = br.readLine()).isEmpty()) {
                pw.println(i);
                pw.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
