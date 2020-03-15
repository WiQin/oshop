package com.oshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author wangyw
 * @date 2020/01/02
 */
@EnableEurekaServer
@SpringBootApplication
public class OShopRegistry {
    public static void main(String[] args) {
        SpringApplication.run(OShopRegistry.class);
    }
}
