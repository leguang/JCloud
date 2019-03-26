package cn.itsite.jbase.common.configuration;

import cn.itsite.jbase.common.interceptor.LoggerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2019/2/10 0010 23:51
 * @description: 其实这种日志拦截器在Springboot中没什么意义，因为当你把debug级别的日志打开的时候，默认就有请求的信息
 */
//@Configuration
public class LoggerConfguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
