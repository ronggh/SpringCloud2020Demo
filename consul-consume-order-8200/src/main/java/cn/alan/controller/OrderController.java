package cn.alan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    // 通过微服务名称获取服务
    private final static String kInvokeUrl = "http://consul-provider-payment";
//    private final static String kInvokeUrl = "http://localhost:8100";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul/order")
    public String paymentInfo() {
        String result = restTemplate.getForObject(kInvokeUrl + "/consul/payment", String.class);
        return result;
    }
}
