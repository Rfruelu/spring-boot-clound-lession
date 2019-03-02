package com.lujia.interceptor;

import com.alibaba.fastjson.JSON;
import com.lujia.domain.LoggerEntity;
import com.lujia.repository.RedisRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author :lujia
 * @date :2018/11/20  16:05
 */
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {


    /**
     * 在拦截器中不能使用autowrite 自动注入bean，
     * 使用WebApplicationContextUtils 通过ServletContext 获取spring上下文context，
     * 再调用getBean获取bean
     *
     * @param tClass
     * @param request
     * @param <T>
     * @return
     */
    private <T> T getDao(Class<T> tClass, HttpServletRequest request) {
        WebApplicationContext requiredWebApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());

        return requiredWebApplicationContext.getBean(tClass);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RedisRoleRepository dao = getDao(RedisRoleRepository.class, request);

       // log.info(dao.toString());


        LoggerEntity loggerEntity=new LoggerEntity();
        loggerEntity.setClientIp(request.getRemoteAddr());
        loggerEntity.setRequestId(request.getRequestedSessionId());
        loggerEntity.setMethod(request.getMethod());

        loggerEntity.setParamData(JSON.toJSONString(request.getParameterMap()));
        loggerEntity.setTime(new Date());
        loggerEntity.setType(request.getContentType());
        loggerEntity.setUrl(request.getRequestURL().toString());
        log.info(JSON.toJSONString(loggerEntity));
        request.setAttribute("REQUEST_LOGGER",loggerEntity);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求处理完成，在DispatcherServlet 渲染了对应的视图之后执行。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        LoggerEntity loggerEntity = (LoggerEntity)request.getAttribute("REQUEST_LOGGER");
        Object  returnValue = request.getAttribute("RETURN_VALUE");
        loggerEntity.setReturnTime(new Date());

        loggerEntity.setReturnData(returnValue);
        loggerEntity.setStatus(response.getStatus());

        log.info("请求日志:"+JSON.toJSONString(loggerEntity));

    }
}
