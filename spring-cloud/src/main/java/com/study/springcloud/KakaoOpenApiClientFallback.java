package com.study.springcloud;

import org.springframework.stereotype.Component;

@Component
public class KakaoOpenApiClientFallback implements KakaoOpenApiClient {

    @Override
    public ResKakaoApi searchDaumWeb(String query) {
        return ResKakaoApi.EMPTY;
    }
}
