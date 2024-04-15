package com.example.day10;

public class Box2<T> {
    private T content;

    public Box2(T content) {
        this.content = content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Box2 containing: " + content;
    }


}
