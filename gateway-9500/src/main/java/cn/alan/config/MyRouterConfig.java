package cn.alan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouterConfig {
    /**
     * 路由到新浪国内新闻,当访问http://localhost:9500/china跳转到
     * https://news.sina.com.cn/china
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRouterChina(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routers = builder.routes();

        // id,唯一即可
        routers.route("router_china",
                r -> r.path("/china")
                        .uri("https://news.sina.com.cn/china")).build();
        return routers.build();
    }

    /**
     * 路由到新浪国际新闻,当访问http://localhost:9500/world跳转到
     * https://news.sina.com.cn/world
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRouterWorld(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routers = builder.routes();

        //
        routers.route("router_world",
                r -> r.path("/world")
                        .uri("https://news.sina.com.cn/world")).build();
        return routers.build();
    }
}
