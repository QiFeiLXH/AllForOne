package org.qifei.apitoken.configuration;

import org.qifei.apitoken.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 13:46
 * @Description
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private static final String[] excludePathPatterns  = {"/api/token/api_token"};

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(excludePathPatterns);
    }
}