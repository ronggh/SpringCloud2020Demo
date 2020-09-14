package cn.alan.cn.alan.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment")
    public String payment() {
        return "Spring cloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID();
    }
}
