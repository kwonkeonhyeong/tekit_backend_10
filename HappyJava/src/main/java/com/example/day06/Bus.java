package com.example.day06;

public class Bus extends Car{
    public Bus() {
        super();
        System.out.println("Bus() 생성자 실행!!");
    }

    public Bus(String name){
        super(name);
        this.name = name;
    }
}
