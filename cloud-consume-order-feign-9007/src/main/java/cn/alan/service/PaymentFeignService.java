package cn.alan.service;

import cn.alan.common.MyResponseResult;
import cn.alan.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    MyResponseResult<Payment> getById(@PathVariable("id") Integer id);
}
