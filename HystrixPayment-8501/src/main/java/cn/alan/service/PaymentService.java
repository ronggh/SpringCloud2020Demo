package cn.alan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " PaymentSuccess id = " + id;
    }

    /**
     * 故意超时，引发异常
     * 使用 @HystrixCommand 进行兜底的处理，指定的兜底的方法与原方法返回值，参数相同
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public String paymentTimeout(Integer id) {
        // 故意超时，引发异常"
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " PaymentTimeout id = " + id;
    }

    // 处理 paymentTimeout() 方法异常的兜底方法
    public String paymentTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " Hystrix Payment -- paymentTimeoutHandler 进行兜底处理 id = " + id;
    }

    // 以下是服务熔断的测试方法
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallbackHandler",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
            })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！！");
        }

        String serialId = UUID.randomUUID().toString();
        return "当前线程：" + Thread.currentThread().getName() + "\t 调用成功，流水号：" + serialId;
    }

    // 熔断兜底方法
    public String paymentCircuitBreakerFallbackHandler(@PathVariable("id") Integer id) {
        return "id 不能负数 id: " + id;
    }

}
