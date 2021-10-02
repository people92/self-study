package com.study.example.java.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class HandlingFile {

    public void downloadFile(String requestUrl) {
        String outputDir = "C:/Code/file";
        InputStream is = null;
        FileOutputStream os = null;
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String fileName = "downloadTest" + System.currentTimeMillis() + ".json";
                System.out.println("fileName = " + fileName);
                File file = new File(outputDir);

                if(!file.exists()) file.mkdirs();

                is = conn.getInputStream();
                os = new FileOutputStream(file + "/" + fileName);

                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = is.read(buffer)) != -1) {
                    // 입력받은 내용을 파일 내용으로 기록한다.
                    os.write(buffer, 0, bytesRead);
                }

            } else {
                System.out.println("fail => responseCode : " + responseCode);
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (is != null){
                    is.close();
                }
                if (os != null){
                    os.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
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
