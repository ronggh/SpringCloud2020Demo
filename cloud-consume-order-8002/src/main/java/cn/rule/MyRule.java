package cn.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * 使用Ribbon自定义负载均衡规则是时，不能与主程序在同一个包下
 * 即所有被@ComponentScan扫描到的包下，均不可，因为会被设置为全局有效了
 * Eureka 默认引入了Ribbion，可以直接使用
 */
@Configuration
public class MyRule {
    /**
     * 设置为随机，默认是轮询
     *
     * @return
     */
//    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
