package net.nalpari.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Desc :
 * @FileName : ApiApplication.java
 * @Project : cloudpack
 * @Date : 2019-03-14
 * @Author : yoosw@3top.co.kr
 */
@SpringBootApplication
public class ApiApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
