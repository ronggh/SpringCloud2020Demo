package cn.alan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: rong
 * 实现配置中心变更后可以动态刷新
 * 1、pom.xml中引入<br/>
 * <!-- spring boot图形化监控,除了网关不能加这个，其它微服务最好加上 -->
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-actuator</artifactId>
 * </dependency>
 * 2、yml文件中增加监控点
 * # 暴露监控端点，可以被spring-boot-starter-actuator监控到变化
 * management:
 * endpoints:
 * web:
 * exposure:
 * include: "*"
 * 3、controller类上添加@RefreshScope 注解
 * 4、每次改完后，需要人工发送一次请求 ：
 * curl -X POST "http://localhost:3355/actuator/refresh"
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private Integer port;


    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/applicationInfo")
    public String getApplicationInfo() {
        return "微服务名称：" + appName + "\t端口号：" + port;
    }
}
