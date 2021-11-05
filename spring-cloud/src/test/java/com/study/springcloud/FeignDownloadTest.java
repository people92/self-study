package com.study.springcloud;

import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FeignDownloadTest {

    @Autowired
    DownloadFeignClient downloadFeignClient;

    @Autowired
    FeignService feignService;

    @Test
    public void downloadJsonFileTest() throws IOException {
        Response response = downloadFeignClient.downloadJsonFile();
        Response.Body body = response.body();
        InputStream inputStream = body.asInputStream();
        String outputDir = "C:/Code/file";
        String fileName = "downloadTest" + System.currentTimeMillis() + ".json";

        if(response.status() == 200) {
            FileOutputStream os = new FileOutputStream(outputDir + "/" + fileName);
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // 입력받은 내용을 파일 내용으로 기록한다.
                os.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            os.close();
        }
    }

    @Test
    public void feignResponseTest() throws IOException {
        feignService.findResponse("SSG");
    }
}
