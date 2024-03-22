package ch02;

        import java.util.Random;
        import java.util.Scanner;

public class MaxOdWeightsRand {
    static int maxOf(int[] weights) {
        int max = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if(max < weights[i]) {
                max = weights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("몸무게의 최대값을 구합니다.");
        System.out.println("사람 수 : ");
        int count = scanner.nextInt();

        int[] weights = new int[count];

        for (int i = 0; i < count; i++) {
            weights[i] = 40 + rand.nextInt(60);
        }

        System.out.printf("최고 몸무게는 %d입니다.", maxOf(weights));
    }
}
