package com.example.day07;

public class InterfaceDemo {
    public static void main(String[] args) {
        // 인터페이스도 타입이다.
        AInter ainter = new DImpl();
        CInter cInter = new DImpl();

        // 자기가 정의한 것만 사용 가능
        ainter.aMethod();
        cInter.cMethod();

        BInter bInter = new DImpl();
        bInter.bMethod();

        AInter a = new AImpl();
        a.aMethod();
        a.same();
        ((AImpl) a).say(); // 타입이 아는 것 까지만 사용 가능하다!!!
    }
}
