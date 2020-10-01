package cn.alan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/zk/payment")
    public String payment() {
        return "Spring cloud with zookeeper: " + serverPort + " ====> " + UUID.randomUUID();
    }
}
