package cn.alan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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