package cn.alan.controller;

import cn.alan.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/payment/success/{id}")
    public String paymentSuccess(@PathVariable("id") Integer id) {
        return paymentService.paymentSuccess(id);
    }

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentTimeout(id);
    }

    //===服务熔断测试方法
    @GetMapping("/hystrix/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
