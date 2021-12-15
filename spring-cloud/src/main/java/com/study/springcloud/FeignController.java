package com.study.springcloud;

import com.study.springcloud.client.KakaoOpenApiClient2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {


    private final FeignService feignService;
    private KakaoOpenApiClient2 kakaoOpenApiClient2;

    public FeignController(FeignService feignService, KakaoOpenApiClient2 kakaoOpenApiClient2) {
        this.feignService = feignService;
        this.kakaoOpenApiClient2 = kakaoOpenApiClient2;
    }

    @GetMapping("/kakao/daum-web")
    public ResKakaoApi searchDaumWeb(@RequestParam(name = "query") String query) {
        return feignService.findDaumWeb(query);
    }

    @GetMapping("/feign/config-test")
    public void testFeignConfig() {
        kakaoOpenApiClient2.searchResponse("TEST");
    }

}
