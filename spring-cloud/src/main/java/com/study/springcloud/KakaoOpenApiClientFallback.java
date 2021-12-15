package com.study.springcloud;

import com.study.springcloud.client.KakaoOpenApiClient;
import feign.Response;
import org.springframework.stereotype.Component;

@Component
public class KakaoOpenApiClientFallback implements KakaoOpenApiClient {

    @Override
    public ResKakaoApi searchDaumWeb(String query) {
        return ResKakaoApi.EMPTY;
    }

    @Override
    public Response searchResponse(String query) {
        return null;
    }
}
