package ch01;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n값: ");
        int n = scanner.nextInt();

        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum+=i;
            i++;
        }

        System.out.println(sum);
    }
}
