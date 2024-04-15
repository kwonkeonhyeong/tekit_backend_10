package com.example.day10.exam;

import java.util.ArrayList;
import java.util.List;

public class CollectionExam03 {
    // 입력 처리
    // Scanner 클래스를 사용하여 사용자로부터 입력을 받습니다.
    // 사용자가 0(더 이상입력하고 싶지 않을 때)을 입력할 때까지 반복하여 점수를 입력받습니다.
    // 입력 받은 점수는 ArrayList<Integer>에 저장됩니다.

    // 점수 유효성 검사
    // 입력 받은 점수가 0부터 100 사이가 아니면 예외를 발생시키고,
    // 에러 메시지로 "0-100사이의 숫자만 입력이 가능합니다." 와 해당 점수를 출력합니다.
    // 예외 발생 시, 에러 스택 트레이스를 출력합니다.

    // 점수 리스트 관리
    // 입력된 0은 점수 리스트에서 제거합니다. (종료 신호로 사용됨)

    // 결과 출력
    // 입력된 점수를 모두 출력합니다.
    // 입력된 모든 점수의 합(총점)과 평균을 계산하여 출력합니다.
    // 평균은 정수로 계산하여 출력합니다.
    private Input input;
    private Output output;
    private List<Score> result;

    public CollectionExam03() {
        this.input = new Input();
        this.output = new Output();
        this.result = new ArrayList<>();
    }

    public void checkScore() {
        boolean exit = false;
        int score = 0;

        while (!exit) {
            output.printNotice();
            score = input.inputNumber();

            if (score == 0) {
                exit = true;
                continue;
            }

            try {
                result.add(new Score(score));

            } catch (ScoreException e) {
                e.printStackTrace();
            }
        }

        output.printResult(result);
    }
}
