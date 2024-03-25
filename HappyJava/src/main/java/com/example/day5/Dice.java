package com.example.day5;

import java.util.Random;

public class Dice {
    private int face;
    private int eye;

    public Dice(int face) {
        this.face = face;
    }

    public void throwDice() {
        Random random = new Random();
        eye = random.nextInt(face) + 1;
    }

    public int getEye() {
        return eye;
    }
}
