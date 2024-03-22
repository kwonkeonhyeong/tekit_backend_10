package ch01;

import java.util.Scanner;

public class TriangleLB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("왼쪽 아래가 직각인 이등변삼각형을 그립니다.");

        do {
            System.out.println("삼각형의 단 수를 입력해주세요: ");
            n = scanner.nextInt();
        } while (n <= 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
