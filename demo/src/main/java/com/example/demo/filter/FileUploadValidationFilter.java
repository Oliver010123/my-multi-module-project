/*
package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component//过滤器
public class FileUploadValidationFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadValidationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        logger.info("接收到请求: URI={}, Method={}", req.getRequestURI(), req.getMethod());

        if ("/upload".equals(req.getRequestURI()) && "POST".equalsIgnoreCase(req.getMethod())) {
            logger.info("开始处理上传请求");
            // 只检查Content-Type，不做MultipartHttpServletRequest强制转换
            String contentType = req.getContentType();
            if (contentType == null || !contentType.toLowerCase().startsWith("multipart/")) {
                logger.error("请求Content-Type不是multipart/form-data: {}", contentType);
                sendError(resp, 400, "请上传文件（请求类型需为multipart/form-data）");
                return;
            }
            // 通过后直接放行，具体文件校验交给Controller
        }
        chain.doFilter(request, response);
    }

    private void sendError(HttpServletResponse response, int code, String message) throws IOException {
        response.setStatus(code);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + message + "\"}");
    }
}

 */