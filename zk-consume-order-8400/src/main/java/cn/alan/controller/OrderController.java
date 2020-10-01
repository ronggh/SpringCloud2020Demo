package cn.alan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    // 通过微服务名称获取服务
    private final static String kInvokeUrl = "http://zk-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zk/order")
    public String paymentInfo() {
        String result = restTemplate.getForObject(kInvokeUrl + "/zk/payment", String.class);
        return result;
    }
}