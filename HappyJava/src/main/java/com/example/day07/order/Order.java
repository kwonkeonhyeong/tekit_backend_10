package com.example.day07.order;

import org.w3c.dom.ls.LSOutput;

abstract public class Order {
    public final void completeOrder() {
        prepareFood();
        serveFood();
        System.out.println("주문이 완료되었습니다.");
    }

    protected abstract void serveFood();

    protected abstract void prepareFood();

}
