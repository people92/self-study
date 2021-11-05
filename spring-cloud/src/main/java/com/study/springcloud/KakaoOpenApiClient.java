package com.study.springcloud;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-open-api",
        url = "https://dapi.kakao.com",
        configuration = KakaoFeignConfiguration.class,
        //fallback = KakaoOpenApiClientFallback.class
        fallbackFactory = KakaoOpenApiClientFallbackFactory.class
        )
public interface KakaoOpenApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/web")
    ResKakaoApi searchDaumWeb(@RequestParam(name = "query") String query);

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/web")
    Response searchResponse(@RequestParam(name = "query") String query);
}
