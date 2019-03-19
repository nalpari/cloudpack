package net.nalpari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Desc :
 * @FileName : ServiceRegistryApplication.java
 * @Project : cloudpack
 * @Date : 2019-03-19
 * @Author : yoosw@3top.co.kr
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}
