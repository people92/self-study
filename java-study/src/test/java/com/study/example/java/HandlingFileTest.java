package com.study.example.java;

import com.study.example.java.file.HandlingFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HandlingFileTest {

    @Test
    public void readFileTest() {
        HandlingFile handlingFile = new HandlingFile();
        String result = handlingFile.readFile();
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void writeFileTest() {
        HandlingFile handlingFile = new HandlingFile();
        handlingFile.writeFile();
    }
}
