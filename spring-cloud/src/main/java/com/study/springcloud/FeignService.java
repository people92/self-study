package com.study.springcloud;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Response;
import feign.RetryableException;
import feign.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

@Service
@Slf4j
public class FeignService {

    private final KakaoOpenApiClient kakaoOpenApiClient;

    public FeignService(KakaoOpenApiClient kakaoOpenApiClient) {
        this.kakaoOpenApiClient = kakaoOpenApiClient;
    }

    public ResKakaoApi findDaumWeb(String query) {
        return kakaoOpenApiClient.searchDaumWeb(query);
    }

    public void findResponse(String query) throws IOException {
        Response response = kakaoOpenApiClient.searchResponse(query);

        int status = response.status();;
        log.info("status :{}", status);

        Map<String, Collection<String>> responseMap = response.headers();

        ResKakaoApi resKakaoApi = new GsonBuilder().create().fromJson(response.body().asReader(StandardCharsets.UTF_8), ResKakaoApi.class);

        log.info(new GsonBuilder().create().toJson(resKakaoApi));

    }
}
