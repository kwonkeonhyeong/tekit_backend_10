package com.example.day5.lotto;

import java.util.Random;

public class LottoMachine {
    private final Ball[] lottoTicket;
    private int ticketIndex;

    public LottoMachine() {
        ticketIndex = 0;
        lottoTicket = new Ball[6];
    }

    public Ball[] draw() {
        Random random = new Random();

        while(ticketIndex < lottoTicket.length) {
            int number = random.nextInt(45) + 1;
            Ball ball = new Ball(number);

            if (ticketIndex == 0) {
                lottoTicket[ticketIndex++] = ball;
                continue;
            }

            if (checkDuplicationBall(ball)) {
                continue;
            }

            lottoTicket[ticketIndex++] = ball;
        }
        ascendingLotto();
        return lottoTicket;
    }

    public boolean checkDuplicationBall(Ball newBall) {
        for (int i = 0; i < ticketIndex; i++) {
            if (newBall.isSame(lottoTicket[i])) {
                return true;
            }
        }
        return false;
    }

    public void ascendingLotto() {
        for (int i = 0; i < lottoTicket.length-1; i++) {
            int min = i;
            for (int j = i+1; j < lottoTicket.length; j++) {
                if(lottoTicket[min].isBig(lottoTicket[j])) {
                    min = j;
                }
            }
            Ball temp = lottoTicket[i];
            lottoTicket[i] = lottoTicket[min];
            lottoTicket[min] = temp;
        }
    }
}
