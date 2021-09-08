package com.study.springcloud;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignRetryConfiguration {
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 2000, 3);
    }
}
