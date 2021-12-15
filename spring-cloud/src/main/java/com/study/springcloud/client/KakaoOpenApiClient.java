package com.study.springcloud.client;

import com.study.springcloud.KakaoOpenApiClientFallbackFactory;
import com.study.springcloud.ResKakaoApi;
import com.study.springcloud.config.KakaoFeignConfiguration;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao",
        url = "https://dapi.kakao.com",
        configuration = KakaoFeignConfiguration.class,
        fallbackFactory = KakaoOpenApiClientFallbackFactory.class
        )
public interface KakaoOpenApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/web")
    ResKakaoApi searchDaumWeb(@RequestParam(name = "query") String query);

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/web")
    Response searchResponse(@RequestParam(name = "query") String query);
}
