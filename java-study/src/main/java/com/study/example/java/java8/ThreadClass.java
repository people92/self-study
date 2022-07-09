package com.study.example.java.java8;

public class ThreadClass {

    public static void main(String[] args) throws InterruptedException {

//        MyThread myThread = new MyThread();
//        myThread.start();

        Thread thread2 = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("Thread2 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }


        });

        thread2.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
   //     Thread.sleep(3000L);
   //     thread2.interrupt();
        thread2.join();
        System.out.println(thread2 + " is done");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
