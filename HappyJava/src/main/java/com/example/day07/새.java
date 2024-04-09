package com.example.day07;

abstract public class 새 {
    abstract public void 노래하다();
}

class 비둘기 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("구구");
    }
}

class 참새 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("참참");
    }
}

class 까마귀 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("까악까악");
    }
}

abstract class 앵무새 extends 새 {
    abstract public void 말하다();
    class  코뉴어 extends 앵무새 {
        @Override
        public void 말하다() {
            System.out.println("하이");;
        }
        @Override
        public void 노래하다() {
            System.out.println("나나나나");;
        }
    }
}
