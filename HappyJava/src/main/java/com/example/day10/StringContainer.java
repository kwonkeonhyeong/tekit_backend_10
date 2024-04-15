package com.example.day10;

public class StringContainer implements Container<String> {
    private String value;
    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    public static void main(String[] args) {
        Container<String> stringContainer = new StringContainer();
        stringContainer.set("hello Container!!!");
        System.out.println(stringContainer.get());
    }
}
