package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnClass({DemoLoginInterceptor.class})
public class DemoWebMvcConfigurer implements WebMvcConfigurer {

//    @Bean
//    public DemoLoginInterceptor loginInterceptor() {
//        DemoLoginInterceptor loginInterceptor = new DemoLoginInterceptor();
//        return loginInterceptor;
//    }



    @Autowired
    SpringSSOInterceptor springSSOInterceptor;

    @Autowired
    DemoLoginInterceptor demoLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springSSOInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(demoLoginInterceptor)
                //.addPathPatterns("/strategy/**")
                .addPathPatterns("/**");
    }

}
