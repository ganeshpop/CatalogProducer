package com.ganesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.ganesh")
public class CatalogProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogProducerApplication.class, args);
    }

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
