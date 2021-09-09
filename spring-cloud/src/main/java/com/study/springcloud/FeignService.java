package com.study.springcloud;


import feign.RetryableException;
import org.springframework.stereotype.Service;

@Service
public class FeignService {

    private final KakaoOpenApiClient kakaoOpenApiClient;

    public FeignService(KakaoOpenApiClient kakaoOpenApiClient) {
        this.kakaoOpenApiClient = kakaoOpenApiClient;
    }

    public ResKakaoApi findDaumWeb(String query) {
        return kakaoOpenApiClient.searchDaumWeb(query);
    }
}
