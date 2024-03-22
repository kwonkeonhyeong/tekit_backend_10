package ch05;

import java.util.Scanner;

public class TailRecursiveFactorial {
    static int factorial(int n, int accumulator) {
        if(n == 1) return accumulator;
        return factorial(n-1,n*accumulator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("팩토리얼을 계산할 정수를 입력하세요: ");
        int x = scanner.nextInt();

        int result = factorial(x,1);
        System.out.println(result);
    }
}
