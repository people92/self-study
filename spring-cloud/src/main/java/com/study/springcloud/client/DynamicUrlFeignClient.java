package com.study.springcloud.client;

import com.study.springcloud.config.KakaoFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "dynamic-url", configuration = KakaoFeignConfiguration.class)
public interface DynamicUrlFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    String searchResponse(URI uri, @RequestParam(name = "query") String query);
}
