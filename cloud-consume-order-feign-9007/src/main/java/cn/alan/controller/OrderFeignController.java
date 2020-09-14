package cn.alan.controller;

import cn.alan.common.MyResponseResult;
import cn.alan.entity.Payment;
import cn.alan.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    public MyResponseResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return paymentFeignService.getById(id);
    }

}
