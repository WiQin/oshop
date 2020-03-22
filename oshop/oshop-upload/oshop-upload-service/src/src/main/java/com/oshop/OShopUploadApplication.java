package com.oshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OShopUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(OShopUploadApplication.class);
    }
}
