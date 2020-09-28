package cn.alan.service.impl;

import cn.alan.service.IPaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements IPaymentService {
    @Override
    public String paymentSuccess(Integer id) {
        return "PaymentFallbackService ---> paymentSuccess";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentFallbackService ---> paymentTimeout";
    }
}
