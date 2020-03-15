package com.oshop.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CORS跨域过滤器
 *
 * @author wyw
 * @date 2020/03/13
 */
@Configuration
public class GlobalCorsCDonfig {

    @Bean
    public CorsFilter corsFilter(){
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1)允许的域，不要写*，否则session无效
        config.addAllowedOrigin("http://manage.oshop.com");
        //2)是否发送Cookie信息
        config.setAllowCredentials(true);
        //3)允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        //4)允许的头信息
        config.addAllowedHeader("*");
        //5)有效时长
        config.setMaxAge(10000L);

        //2.添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**",config);

        //3.返回新的CorsFilter
        return new CorsFilter(configSource);
    }
}
