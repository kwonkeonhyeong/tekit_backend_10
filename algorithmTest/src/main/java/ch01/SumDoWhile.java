package ch01;

import java.util.Scanner;

public class SumDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
         n = scanner.nextInt();
        } while( n <= 0);

        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum+=i;
        }
        System.out.println(sum);

        int oddSum = 0;
        for (int i = 1; i < n + 1; i++) {
            if(i%2 != 0) {
                oddSum += i;
            }
        }
        System.out.println(oddSum);
    }
}
