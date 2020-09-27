package cn.alan.service;

import cn.alan.common.MyResponseResult;
import cn.alan.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通过OpenFeign调用cloud-provider-payment中定义的方法
 */
@FeignClient(value = "cloud-payment-service")
public interface IPaymentService {
    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    MyResponseResult<Payment> getById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/payment/openfeign/timeout", method = RequestMethod.GET)
    String testTimeOut();
}
