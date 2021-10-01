package com.study.example.java.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;


public class HandlingFile {

    public String readFile() {
        String filePath = "C:/Code/file/fileText.txt";

        File file = new File(filePath);

        StringBuilder sb = new StringBuilder();

        try {
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line = null;

                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                bufferedReader.close();
            } else {
                System.out.println("파일이 존재하지 않습니다.");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return sb.toString();
    }
    public void writeFile() {

        String filePath = "C:/Code/file/fileText" + System.currentTimeMillis() +".txt";

        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            bufferedWriter.write("TEST1");
            bufferedWriter.newLine();
            bufferedWriter.write("TEST2");

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
