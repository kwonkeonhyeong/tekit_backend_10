package com.example.day13;

class DemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("배경음악 재생중!!!");
        }
    }
}

public class ThreadJoinExample2 {
    static class TaskThread extends Thread {
        private String taskName;

        public TaskThread(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(taskName + " 작업 시작");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " 작업 완료");
        }
    }

    public static void main(String[] args) {
        TaskThread task1 = new TaskThread("작업1");
        TaskThread task2 = new TaskThread("작업2");

        DemonThread demonThread = new DemonThread();

        task1.start();
        task2.start();

        demonThread.setDaemon(true);
        demonThread.start();

        try {
            System.out.println("모든 작업의 완료를 기다립니다.");
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("모든 작업이 완료되었습니다.");
    }
}
