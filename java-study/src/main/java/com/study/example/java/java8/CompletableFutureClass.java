package com.study.example.java.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("jay");
//        System.out.println(completableFuture.get());
//
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//        });
//
//        voidCompletableFuture.get();


        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello : " + Thread.currentThread().getName());
            return "Hello";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 : " + Thread.currentThread().getName());
            return "Hello2";
        });

//        CompletableFuture<String> future = completableFuture1.thenCompose(CompletableFutureClass::getWorld);
//        System.out.println(future.get());


        CompletableFuture<String> future = completableFuture1.thenCombine(completableFuture2, (h, w) -> {
            return h + " " + w;
        });
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String messsage) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World : " + Thread.currentThread().getName());
            return  messsage + " World";
        });
    }
}
