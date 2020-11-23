package com.borrow.book.aspect;


import com.alibaba.fastjson.JSONObject;
import com.borrow.book.domain.ResultBody;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.borrow.book.controller.*.*(..))")
    public void ControllerMethod() {}


    @Before("ControllerMethod()")
    public void BeforeLogControllerMethod(JoinPoint joinPoint) {
        //request
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //bulider拼接请求message
        StringBuilder requestLog=new StringBuilder();

        Signature signature = joinPoint.getSignature();

        requestLog.append("请求信息").append("\t").append("Url = {").append(request.getRequestURI()).append("},\t")
                .append("请求方式 ={").append(request.getMethod()).append("} \t")
                .append("请求ip {").append(request.getRemoteAddr()).append("} \t")
                .append("方法 ={").append(signature.getDeclaringTypeName()).append(".")
                .append(signature.getName()).append("} \t");
        //处理请求参数
        String[] paramsNames=((MethodSignature) signature).getParameterNames();
        Object[] paramsValues=joinPoint.getArgs();

        int paramLength = null ==paramsNames ? 0 :paramsNames.length;
        if (paramLength==0) {
            requestLog.append("请求参数 ={}");
        }else {
            requestLog.append("请求参数 ={");
            for (int i = 0; i < paramLength -1; i++) {
                requestLog.append(paramsNames[i]).append("=").append(JSONObject.toJSONString(paramsNames[i])).append(",");
            }
            requestLog.append(paramsNames[paramLength-1]).append("=").append(JSONObject.toJSONString(paramsNames[paramLength-1])).append(",");
        }
        logger.info(requestLog.toString());
    }

    @AfterReturning(returning = "resultBody",pointcut="ControllerMethod()")
    public void AfterControllerMethod(ResultBody resultBody){
        logger.info("返回结果:"+resultBody.getCode()+","+resultBody.getMessage());
    }
}
