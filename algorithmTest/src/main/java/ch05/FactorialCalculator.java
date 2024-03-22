package ch05;

import java.util.Scanner;

public class FactorialCalculator {
    static int computerFactorial(int n) {
        if(n > 0) {
            return n * computerFactorial(n-1);
        } else {
            return 1;
        }
    }

//    static int factorial(int n) {
//        int fact = 1;
//        while(n>0){
//            fact = fact * n--;
//        }
//        return fact;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 정수를 입력하세요.");
        int n = scanner.nextInt();
        System.out.println(computerFactorial(n));
//        System.out.println(factorial(n));
    }
}
