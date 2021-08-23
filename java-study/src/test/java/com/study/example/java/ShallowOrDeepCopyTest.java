package com.study.example.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ShallowOrDeepCopyTest {

    @Test
    public void shallowCopyListTest() {
        List<String> sourceList = Arrays.asList("order", "delivery", "claim", "return");

        List<String> targetList = sourceList;

        sourceList.add("cancel");

        System.out.print("source list : ");
        sourceList.forEach(System.out::println);
        System.out.print("target list : ");
        targetList.forEach(System.out::println);
    }

    @Test
    public void deepCopyListTest() {

    }

    @Test
    public void shallowCopyObjectTest() {

    }

    @Test
    public void deepCopyObjectTest() {

    }
}
