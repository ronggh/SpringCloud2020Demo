package cn.alan.cn.alan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {
    private final static String kInvokeUrl = "http://cloud-provider-payment-consul-8006";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume/payment")
    public String paymentInfo() {
        String result = restTemplate.getForObject(kInvokeUrl + "/payment", String.class);
        return result;
    }
}
