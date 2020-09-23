package cn.alan.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
public class MyGlobalLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("==========> Come in MyGlobalLogFilter " + new Date());
        // 假设需要第一个参数为用户名
        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (null == userName || "".equals(userName)) {
            System.out.println("***********非法用户***********");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 继续向下一个过滤器传递
        return chain.filter(exchange);
    }

    /**
     * 过滤器的加载顺序，数字越小，优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
