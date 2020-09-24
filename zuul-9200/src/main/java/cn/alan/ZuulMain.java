package cn.alan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author : rong
 * @EnableZuulProxy 开启zuul的网关代理功能
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulMain {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class, args);
    }
}