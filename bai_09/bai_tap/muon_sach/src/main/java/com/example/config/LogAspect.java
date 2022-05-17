package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(*(com.example).controller.BookController.show*(..))")
    public void payAndBorrowPoinCut(){

    }
@Before("payAndBorrowPoinCut()")
    public void beforePayAndBorrow(JoinPoint joinPoint){
        int count = 0;
    System.out.println("start method name: "+joinPoint.getSignature().getName()+count++);
}
@AfterReturning("payAndBorrowPoinCut()")
    public void afterReturningPayAndBorrowPoinCut(JoinPoint joinPoint){
    int count = 0;
    System.out.println("end method name: "+joinPoint.getSignature().getName()+count++);
}
}
