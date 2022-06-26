package com.study.example.java.java8;

@FunctionalInterface
public interface SampleInterface {

    void run();

    static void printName() {
        System.out.println("TEST");
    }

    default void printAge() {
        System.out.println("31");
    }
}
