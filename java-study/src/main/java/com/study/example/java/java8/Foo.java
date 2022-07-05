package com.study.example.java.java8;

public interface Foo {

    void printName();


    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}
