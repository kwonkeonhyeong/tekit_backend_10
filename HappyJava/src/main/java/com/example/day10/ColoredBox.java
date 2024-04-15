package com.example.day10;

public class ColoredBox<T,C> extends Box2<T>{
    private C color;

    public ColoredBox(T content, C color) {
        super(content);
        this.color = color;
    }

    public C getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ColorBox box with color" + color + " containing" + getContent();
    }

    public static void main(String[] args) {
        ColoredBox<String,String> coloredBox = new ColoredBox<>("pen","red");
        System.out.println(coloredBox);
    }
}
