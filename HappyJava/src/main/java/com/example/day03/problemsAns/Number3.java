package com.example.day03.problemsAns;

import java.util.Scanner;

public class Number3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }

            if(count == 2) {
                result++;
            }
        }
        System.out.println(result);
    }
}
