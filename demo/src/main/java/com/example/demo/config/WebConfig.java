/*
package com.example.demo.config;

import com.example.demo.interceptor.FileValidationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {//将拦截器注册到Spring MVC中，只对/upload路径生效

    @Autowired
    private FileValidationInterceptor fileValidationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fileValidationInterceptor)
                .addPathPatterns("/upload"); // 仅拦截 /upload 请求
    }
}
*/
