package ch02;

import java.util.Scanner;

public class MaxOfScores {
    static int maxOf(int[] scores) {
        // 방법 1
//        int max = Integer.MIN_VALUE;
//        for (int score : scores) {
//            max = Math.max(max,score);
//        }
//        return max;
//
        // 방법 2
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (max < scores[i]) {
                max = scores[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력해주세요: ");
        int count = scanner.nextInt();

        int[] scores = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.printf("%d번째 성적을 입력해주세요: ",i+1);
            scores[i] = scanner.nextInt();
        }

        System.out.printf("최댓값은 %d입니다.",maxOf(scores));
    }
}
