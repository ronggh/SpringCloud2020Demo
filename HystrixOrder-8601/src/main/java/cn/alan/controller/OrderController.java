package cn.alan.controller;

import cn.alan.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 指定全局统一的处理方法
//@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/hystrix/order/success/{id}")
    public String paymentSuccess(@PathVariable("id") Integer id) {
        return paymentService.paymentSuccess(id);
    }

    // 单独指定自己的方法
    // @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    // 只使用 @HystrixCommand ，就默认使用全局统一的处理方法
//    @HystrixCommand
    @GetMapping("/hystrix/order/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentTimeout(id);
    }

    // 处理 paymentTimeout() 方法异常的兜底方法
    public String paymentTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " Hystrix Order -- 支付系统繁忙，请稍后再试!!! id = " + id;
    }

    // 全局统一的失败处理
    public String globalFallback() {
        return "对方系统繁忙或宕机，暂时无法访问，请稍后再试！！";
    }
}
