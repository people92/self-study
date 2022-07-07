package com.study.example.java.java8;

import java.util.*;

public class DefaultFoo implements Foo{

    private String name;

    public DefaultFoo(String name) {
        this.name = name;
    }
    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("jay");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();

        List<String> names = new ArrayList<>();
        names.add("MINJUNG");
        names.add("JAY");
        names.add("eminjae");
        names.add("TTTT");

        names.forEach(System.out::println);

        System.out.println("===================");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("===================");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("===================");

        //names.removeIf(s -> s.startsWith("T"));

        Comparator<String> comparator = String ::compareToIgnoreCase;
        names.sort(comparator.reversed());
    }
}
