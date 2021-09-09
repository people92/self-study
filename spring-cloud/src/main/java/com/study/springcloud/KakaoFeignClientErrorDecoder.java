package com.study.springcloud;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class KakaoFeignClientErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        System.out.println("Error decode Test");

        if (404 == response.status()) {
            return new RetryableException(404, response.reason(), response.request().httpMethod(), null, response.request());
        }

        return defaultErrorDecoder.decode(s, response);
    }
}
