package com.example.springboot.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author zhengwei he
 */
@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.example.springboot.controller..*.*(..))")
    public void webControllerLog() {
    }

    @Before("webControllerLog()")
    public boolean beforeLog(JoinPoint joinPoint) {
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttribute).getRequest();
        logger.info(request.getRequestURI());
        logger.info(request.getQueryString());
        logger.info(joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        return true;
    }

}
