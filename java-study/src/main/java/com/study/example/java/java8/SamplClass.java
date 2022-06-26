package com.study.example.java.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SamplClass {

    public static void main(String[] args) {
        SampleInterface sampleInterface = new SampleInterface() {
            @Override
            public void run() {
                System.out.println("run2");
            }
        };
        SampleInterface sampleInterface2 = () -> System.out.println("run");
        sampleInterface2.run();

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus10Interface = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlust10 = plus10Interface.compose(multiply2);
        System.out.println(multiply2AndPlust10.apply(2));

        Function<Integer, Integer> multiply2AndThenPlust10 = plus10Interface.andThen(multiply2);
        System.out.println(multiply2AndThenPlust10.apply(2));

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWith = (s) -> s.startsWith("yun");
        Predicate<String> startsWith2 = (s) -> s.startsWith("min");
        System.out.println(startsWith.test("yunmin"));
        System.out.println(startsWith.negate().test("yunming"));
        System.out.println(startsWith.and(startsWith2).test("yun"));
        System.out.println(startsWith.or(startsWith2).test("min"));


    }
}
