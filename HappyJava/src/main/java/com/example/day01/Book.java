package com.example.day01;

public class Book {
    private String title;
    /*
    속성, 필드 Java에서
    속성을 도출하는 과정을 추상화라고 한다.
    */
    private int price;

    public Book() {
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    // 메서드
    // 접근제한자 리턴타입 메소드명(매개변수들...) { 구현 }
    // 필드의 값을 수정하고 얻기 위한 메소드를 만든다. setter, getter
    // setter, getter - 프로터피(property) - price 프로퍼티
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price * 2; // this는 내 자신 인스턴스를 참조하는 예약어.
    }

    public void setPrice(int price) { // 지역변수 price
        this.price = price;
    }

}
