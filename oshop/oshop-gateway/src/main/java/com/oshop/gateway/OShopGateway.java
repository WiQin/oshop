package com.oshop.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wangyw
 * @date 2020/01/02
 */
@EnableZuulProxy
@SpringCloudApplication
public class OShopGateway {
    public static void main(String[] args) {
        SpringApplication.run(OShopGateway.class);
    }
}
