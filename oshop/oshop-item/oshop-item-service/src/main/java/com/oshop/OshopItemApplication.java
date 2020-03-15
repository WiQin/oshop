package com.oshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.oshop.item.mapper")
public class OshopItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OshopItemApplication.class);
    }
}
