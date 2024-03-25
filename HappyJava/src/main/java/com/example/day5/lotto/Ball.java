package com.example.day5.lotto;

public class Ball {
    private int number;

    public Ball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Ball ball) {
        return this.number == ball.getNumber();
    }

    public boolean isBig(Ball ball) {
        return this.number > ball.getNumber() ;
    }
}
