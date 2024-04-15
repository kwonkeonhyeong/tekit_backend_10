package com.example.day10.exam;

public class Score {
    private int Score;

    public Score(int score) throws ScoreException {
        validateRange(score);
        this.Score = score;
    }

    public void validateRange(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("입력한 점수가 0~100 사이의 값이 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(Score);
    }
}
