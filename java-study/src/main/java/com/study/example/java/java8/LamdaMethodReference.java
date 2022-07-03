package com.study.example.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LamdaMethodReference {

    private String name;

    public LamdaMethodReference() {

    }

    public LamdaMethodReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }

    public static void main(String[] args) {

        //스태틱 메소드 참조
        UnaryOperator<String> hi = LamdaMethodReference::hi;

        //특정 객체의 인스턴스 메소드 참조
        LamdaMethodReference lamdaMethodReference = new LamdaMethodReference();
        UnaryOperator<String> hello = lamdaMethodReference :: hello;
        System.out.println(hello.apply("minjung"));

        
        //생성자 참조
        Supplier<LamdaMethodReference> lamdaMethodReferenceSupplier = LamdaMethodReference::new;

        Function<String, LamdaMethodReference> lamdaMethodReferenceFunction
                = LamdaMethodReference::new;
        LamdaMethodReference lamdaMethodReference1 = lamdaMethodReferenceFunction.apply("JJJ");
        System.out.println(lamdaMethodReference1.getName());

        //임의 객체의 인스턴스 메소드 참조
        String[] names = {"minjung", "jay", "sooj"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
