package com.example.demo.asp;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * https://blog.csdn.net/u011277123/article/details/101544614
 */
@Aspect
@Component
@Slf4j
public class RetryAspect {

     /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法。
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.example.demo.asp.Retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        Retry retryInfo = AnnotationUtils.findAnnotation(method, Retry.class);
        int maxAttempts = retryInfo.maxAttempts();
        int numAttempts = 0;
        do {
            numAttempts ++;
            try {
                return joinPoint.proceed();
            }catch (Exception e){
                log.error("RetryAspect_reTried", e);
            } catch (Throwable e) {
                throw e;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.info("doRetry_wait_interrupted");
            }
        } while (numAttempts < maxAttempts - 1);
        numAttempts ++;
        log.info("重试次数:{}", numAttempts);
        return joinPoint.proceed();
    }




    @Before("@annotation(com.example.demo.asp.Retry)")
    public void beforeMethod(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method "+methodName+" begins with "+ Arrays.asList(args));
    }

    @After("@annotation(com.example.demo.asp.Retry)")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" end......");
    }

    /**
     * 返回通知
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问方法的返回值的！
     * @param joinPoint*/
    @AfterReturning(value = "@annotation(com.example.demo.asp.Retry)", returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" end......result:"+result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定在出现特定异常时在执行通知代码
     * @param joinPoint
     * @param ex*/

    @AfterThrowing(value = "@annotation(com.example.demo.asp.Retry)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +"occurs exception :" +ex);
    }

}
