package cn.alan.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

//@Configuration
public class KeyResolverConfiguration {
    /**
     * 基于请求路径的限流
     */
//    @Bean
//    public KeyResolver pathKeyResolver() {
//        return exchange -> Mono.just(
//                exchange.getRequest().getPath().toString()
//        );
//    }

    /**
     * 基于请求ip地址的限流
     */
//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(
//                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")
//        );
//    }

    /**
     * 基于用户的限流
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest().getQueryParams().getFirst("userName")
        );
    }
}
