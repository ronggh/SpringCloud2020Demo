package cn.alan.service;


import cn.alan.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "HystrixPayment", fallback = PaymentFallbackService.class)
public interface IPaymentService {
    @GetMapping("/hystrix/payment/success/{id}")
    String paymentSuccess(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Integer id);
}
