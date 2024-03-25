package com.example.day04;

public class ItemForArray {
    private int price; // 속성, 필드
    private String name;

    // 기본 생성자
    // 기본 생성자는 다른 생성자가 하나라도 있으면 자동으로 만들어지지 않는다.
    public ItemForArray(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
