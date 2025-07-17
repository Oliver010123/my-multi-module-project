package com.example.demo.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UploadStrategyContext {
    @Value("${file.upload.strategy:localUploadStrategy}")
    private String strategyName;

    @Autowired
    private ApplicationContext applicationContext;

    public UploadStrategy getStrategy() {
        return applicationContext.getBean(strategyName, UploadStrategy.class);
    }
}
