package org.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(* org.example.aopexam.SimpleService.*(..))")
    public void pc() {}

    @Pointcut("execution(* hello())")
    public void pc2() {}

    @Before("execution(* org.example.aopexam.SimpleService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before ::::::::::" + joinPoint.getSignature().getName());
    }

    @Before("execution(* setName(..))")
    public void beforeName(JoinPoint joinPoint) {
        System.out.println("beforeName:::::::::::::");
        System.out.println("method name :::: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(":::::::::::::인자 --->" + arg);
        }
    }

    @AfterThrowing(value = "pc2()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("AfterThrowing #############");
        System.out.println("exception value :: " + ex);
    }


//    @After("execution(* org.example.aopexam.SimpleService.*(..))")
//    public void after() {
//        System.out.println("after ::::::::::");
//    }

    @AfterReturning(pointcut = "execution(String org.example.aopexam.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After method " + joinPoint.getSignature().getName() + ", return value: " + result);
    }

    @After("pc2()")
    public void after() {
        System.out.println("after ::::::::::");
    }

    @Around("pc()")
    public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around run ::::::::::::::::::: 실제 호출된 메서드가 실행되기 전에 할인 구현");
        String value = (String) proceedingJoinPoint.proceed();// 실제 target 메소드를 호출
        System.out.println("Around run ::::::::::::::::::: 실제 호출된 메서드가 실행되기 후 할인 구현");
        value += "carami aop run!!";
        return value;
    }
}
