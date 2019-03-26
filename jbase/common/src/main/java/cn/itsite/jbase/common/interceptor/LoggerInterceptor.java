package cn.itsite.jbase.common.interceptor;

import cn.itsite.jbase.common.helper.JsonHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2019/2/10 0010 23:51
 * @description: 其实这种日志拦截器在Springboot中没什么意义，因为当你把debug级别的日志打开的时候，默认就有请求的信息
 */
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.debug("--> " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.debug("{}:{}", headerNames.nextElement(), request.getHeader(headerName));
        }

        log.debug(JsonHelper.object2String(request.getParameterMap()));

        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        long time = System.currentTimeMillis() - ((long) request.getAttribute(LOGGER_SEND_TIME));
        log.debug("<-- " + response.getStatus() + " " + request.getRequestURI() + " (" + time + ")");

        for (String headerName : response.getHeaderNames()) {
            log.debug("{}:{}", headerName, response.getHeader(headerName));
        }
    }
}
