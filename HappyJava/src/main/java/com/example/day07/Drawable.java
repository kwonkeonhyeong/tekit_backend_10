package com.example.day07;

public interface Drawable {
    public void draw();
    default void defaultDraw() {
        System.out.println("도형을 그립니다.");
    };
}

