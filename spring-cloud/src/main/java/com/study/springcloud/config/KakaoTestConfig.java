package com.study.springcloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class KakaoTestConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "TEST");
        requestTemplate.header("TEST", "T");
    }
}
