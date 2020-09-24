package cn.alan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

// 先注释上，不让这个自定义的过滤器起作用
//@Component
public class MyLoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 登录校验，肯定是在前置拦截
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 顺序设置, 越小优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 返回true，代表过滤器生效。
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 登录校验逻辑。
        // 1、获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2、从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3、从请求中获取token
        String token = req.getParameter("access-token");
        // 4、判断
        if (token == null || "".equals(token.trim())) {
            // 没有token，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return null;
    }
}
