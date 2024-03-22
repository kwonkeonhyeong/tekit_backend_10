package ch01;

import java.util.Scanner;

public class SumFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum += i;
        }

        System.out.println(sum);

        int evenSum = 0;
        for (int i = 1; i < n+1; i++) {
            if (i%2 == 0) {
                evenSum += i;
            }
        }
        System.out.println(evenSum);

        int multiple3 = 0;
        for (int i = 1; i < n+1; i++) {
            if (i%3 == 0) {
                multiple3 += i;
            }
        }
        System.out.println(multiple3);
    }
}
