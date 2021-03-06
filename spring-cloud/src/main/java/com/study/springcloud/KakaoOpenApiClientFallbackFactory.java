package com.study.springcloud;

import com.study.springcloud.client.KakaoOpenApiClient;
import feign.Response;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KakaoOpenApiClientFallbackFactory implements FallbackFactory<KakaoOpenApiClient> {

    @Override
    public KakaoOpenApiClient create(Throwable cause) {
        return new KakaoOpenApiClient() {
            @Override
            public ResKakaoApi searchDaumWeb(String query) {
                log.error("Feign Client Error : " + cause.getMessage());
                return ResKakaoApi.EMPTY;
            }

            @Override
            public Response searchResponse(String query) {
                return null;
            }
        };
    }
}
