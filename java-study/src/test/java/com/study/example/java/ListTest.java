package com.study.example.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    @Test
    public void generalCreateList() {
        List<String> sourceList = new ArrayList<>();
        sourceList.add("order");
        sourceList.add("delivery");
        sourceList.add("claim");
        sourceList.add("return");
        sourceList.stream().forEach(System.out::println);
        Assertions.assertFalse(sourceList.isEmpty());
    }
    @Test
    public void throwUnsupportedOperationExceptionTest() {
        List<String> sourceList = Arrays.asList("order", "delivery", "claim", "return");

        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            sourceList.add("cancel");
        });
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            sourceList.remove(0);
        });
    }
    @Test
    public void notThrowUnsupportedOperationExceptionTest() {
        List<String> sourceList = new ArrayList<>(Arrays.asList("order", "delivery", "claim", "return"));
        sourceList.add("cancel");
        sourceList.stream().forEach(System.out::println);
        Assertions.assertEquals(5, sourceList.size());
    }
}
