package ch02;

public class TwoDimensionalArrayInitialization {
    public static void main(String[] args) {
        int[][] score = {
                {90, 80, 70, 60},
                {80, 70, 60, 50},
                {70, 60, 50, 40}
        };

        // 배열의 내용 출력
        for (int i = 0; i < score.length; i++) {
            int sum = 0;
            System.out.println(i+1 + "번째 학생의 과목 점수: ");
            for (int j = 0; j < score[i].length; j++) {
                System.out.println(score[i][j]);
                sum+= score[i][j];
            }
            System.out.println(i+1 + "번 학생의 총점 : " + sum);
            System.out.printf("%d번 학생의 평균 : %.2f",i+1 , (double )sum/score[i].length);
            System.out.println();
        }
    }
}
