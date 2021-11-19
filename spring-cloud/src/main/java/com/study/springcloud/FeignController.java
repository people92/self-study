package com.study.springcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {


    private final FeignService feignService;


    public FeignController(FeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping("/kakao/daum-web")
    public ResKakaoApi searchDaumWeb(@RequestParam(name = "query") String query) {
        return feignService.findDaumWeb(query);
    }

}
