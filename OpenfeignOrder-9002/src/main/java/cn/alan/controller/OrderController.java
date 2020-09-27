package cn.alan.controller;


import cn.alan.common.MyResponseResult;
import cn.alan.entity.Payment;
import cn.alan.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openfeign/order")
public class OrderController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping(value = "/get/{id}")
    public MyResponseResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @GetMapping(value = "/testTimeOut")
    public String testTimeOut() {
        return paymentService.testTimeOut();
    }
}
