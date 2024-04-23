package com.example.babylion.io;

import com.example.babylion.io.Exam04.User1.Counter;
import com.example.babylion.io.Exam04.User1.User2;

public class Exam04 {
    private static final Counter counter = new Counter();

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread user1 = new Thread(new User1(3));
        Thread user2 = new Thread(new User2(2));

        user1.start();
        user2.start();

        System.out.println(counter.getCount());
    }

    static class User1 implements Runnable {

        private final int addCount;

        public User1(int addCount) {
            this.addCount = addCount;
        }

        @Override
        public void run() {
            synchronized (Exam04.counter) {
                for (int i = 0; i < addCount; i++) {
                }
                counter.add();
            }
        }

        static class User2 implements Runnable {

            private final int addCount;

            public User2(int addCount) {
                this.addCount = addCount;
            }

            @Override
            public void run() {
                synchronized (Exam04.counter) {
                    for (int i = 0; i < addCount; i++) {
                    }
                    counter.add();
                }
            }
        }

        static class Counter {
            private int count = 0;

            public void add() {
                count++;
            }

            public int getCount() {
                return count;
            }
        }
    }
}

