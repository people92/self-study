package com.study.example.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread : " + Thread.currentThread().getName());
//            }
//        });
//        executorService.submit(() -> {
//            System.out.println("Thread : " + Thread.currentThread().getName());
//        });
//
//        executorService.shutdown();
//        executorService.shutdownNow();
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> jay = () -> {
            Thread.sleep(1000L);
            return "Jay";
        };

        List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(hello, java, jay));

        for(Future<String> f : futureList) {
            System.out.println(f.get());
        }

        String s = executorService.invokeAny(Arrays.asList(hello, java, jay));
        System.out.println(s);

//        Future<String> future = executorService.submit(hello);
//
//        System.out.println(future.isDone());
//        System.out.println("Started!");
//        future.cancel(false);
//        future.get();
//
//        System.out.println(future.isDone());
//        System.out.println("End!");
        executorService.shutdown();

    }
}
