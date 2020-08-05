package com.abc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class DepartCodeConfigure {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
