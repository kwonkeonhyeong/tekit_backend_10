package com.example.day05;

public class DiceMain {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        dice.throwDice();
        System.out.println(dice.getEye());
    }
}
