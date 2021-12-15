package com.study.springcloud;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.springcloud.client.KakaoOpenApiClient;
import feign.Request;
import feign.Response;
import feign.codec.StringDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Component
@Slf4j
public class FeignService {

    private KakaoOpenApiClient kakaoOpenApiClient;
    private StringDecoder stringDecoder = new StringDecoder();

    public FeignService(KakaoOpenApiClient kakaoOpenApiClient) {
        this.kakaoOpenApiClient = kakaoOpenApiClient;
    }

    public ResKakaoApi findDaumWeb(String query) {
        return kakaoOpenApiClient.searchDaumWeb(query);
    }

    public void findResponse(String query) throws IOException {
        Response response = kakaoOpenApiClient.searchResponse(query);

        int status = response.status();
        log.info("status :{}", status);

        Map<String, Collection<String>> resHeaderMap = response.headers();
        log.info("headers : {}", new Gson().toJson(resHeaderMap));

        String body = stringDecoder.decode(response, String.class).toString();
        log.info("body : {}", body);

        String reason = response.reason();
        log.info("reason : {}", reason);

        Request request = response.request();
        String url = request.url();
        log.info("request url :{}",url);
        Map<String, Collection<String>> reqHeaderMap = request.headers();
        log.info("request headers : {}", new GsonBuilder().create().toJson(reqHeaderMap));

        log.info("request httpMethod : {}", request.httpMethod().name());

    }

}
