package com.example.day07;

public class DImpl implements DInter{

    @Override
    public void dMethod() {
        System.out.println("dMtehod 구현");
    }

    @Override
    public void aMethod() {
        System.out.println("aMtehod 구현");
    }

    @Override
    public void same() {
        System.out.println("same 구현");
    }

    @Override
    public void cMethod() {
        System.out.println("cMtehod 구현");
    }

    @Override
    public void bMethod() {
        System.out.println("bMethod 구현");
    }
}
