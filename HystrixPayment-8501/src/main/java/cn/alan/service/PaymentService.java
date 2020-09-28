package cn.alan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
