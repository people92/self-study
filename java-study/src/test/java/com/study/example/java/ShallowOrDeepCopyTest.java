package com.study.example.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShallowOrDeepCopyTest {

    @Test
    public void shallowCopyListTest() {
        List<String> sourceList = new ArrayList<>(Arrays.asList("order", "delivery", "claim", "return"));

        List<String> targetList = sourceList;

        sourceList.add("cancel");

        System.out.println("source list : " + sourceList);
        System.out.println("source list : " + sourceList.hashCode());

        System.out.println("target list : " + targetList);
        System.out.println("target list : " + targetList.hashCode());
        
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
