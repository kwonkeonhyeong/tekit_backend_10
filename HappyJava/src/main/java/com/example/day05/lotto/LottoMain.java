package com.example.day05.lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        System.out.println("추첨된 Lotto 번호");
        for (Ball ball : lottoMachine.draw()) {
            System.out.print(ball.getNumber() + "\t");
        }
    }
}
