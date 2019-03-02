package com.example.lujia.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2018/6/25.
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        log.info(String.format("%s>>>>%s",request.getMethod(),request.getRequestURL().toString()));

        String token = request.getParameter("token");

        if (null==token||token.equals("")){
            log.warn("token is null");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);

            try {
                currentContext.getResponse().getWriter().write("roken is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");

        return null;
    }
}
