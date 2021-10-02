package com.study.springcloud;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "download-api",
        url = "https://raw.githubusercontent.com/people92/self-study/main/java-study/src/main/resources/json"
)
public interface DownloadFeignClient {

    @GetMapping(value = "/sample.json")
    Response downloadJsonFile();
}
