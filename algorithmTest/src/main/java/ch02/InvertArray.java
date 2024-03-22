package ch02;

import java.util.Arrays;
import java.util.Scanner;

public class InvertArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수의 개수: ");
        int num = scanner.nextInt();

        int[] scores = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.printf("score[%d]: ",i);
            scores[i] = scanner.nextInt();
        }

        reverse(scores);
        System.out.println("점수를 역순으로 정렬했습니다.");
        System.out.println("scores = " + Arrays.toString(scores));
    }

    static void reverse(int[] scores) {
        for (int i = 0; i < scores.length/2; i++) {
            swap(scores,i,scores.length - i - 1);
        }
    }

    static void swap(int[] a, int index1, int index2) {
        int i = a[index1];
        a[index1] = a[index2];
        a[index2] = i;
    }
}
