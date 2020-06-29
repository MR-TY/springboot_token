package com.ty.token.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author tangyu
 * @date 2020/6/28
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private static final String[] excludePathPatterns  = {"/api/token/api_token"};

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Autowired
    private ApiInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/hello/**")
                .excludePathPatterns("/api/**");
    }
}