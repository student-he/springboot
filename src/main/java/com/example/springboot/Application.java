package com.example.springboot;

import com.example.springboot.utils.WebInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author zhengwei he
 */
@SpringBootApplication
@MapperScan("com.example.springboot.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public static class InterceptorConfig implements WebMvcConfigurer {

        @Resource
        private WebInterceptor interceptorTest;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptorTest)
                    //需要拦截的请求
                    .addPathPatterns("/test/methA")
                    //不需要拦截的请求
                    .excludePathPatterns("/test/methB");
        }

    }
}
