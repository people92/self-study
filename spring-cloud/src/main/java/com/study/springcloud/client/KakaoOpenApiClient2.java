package com.study.springcloud.client;


import com.study.springcloud.config.KakaoTestConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-test",
        url = "https://www.naver.com",
        configuration = KakaoTestConfig.class
)
public interface KakaoOpenApiClient2 {

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/web")
    Response searchResponse(@RequestParam(name = "query") String query);
}
