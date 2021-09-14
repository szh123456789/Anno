package com.aspect;

import com.anno.Anno;
import com.dao.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import sun.nio.cs.US_ASCII;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class AnnoAsp {

    @Pointcut("@annotation(com.anno.Anno)")
    private void pointcut(){}

//    @Before("pointcut() && @annotation(ano)")
//    public void advice(JoinPoint joinPoint, Anno ano){
//        System.out.println("打印内容为"+ano.value()+"---");
//        System.out.println("注解作用的方法名" + joinPoint.getSignature().getName());
//        System.out.println("所在类的简单类名" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println("所在类的完整类名" + joinPoint.getSignature().getDeclaringType());
//        System.out.println("目标方法的声明类型" + Modifier.toString(joinPoint.getSignature().getModifiers()));
//
//        System.out.println("["+
//                joinPoint.getSignature().getDeclaringType().getSimpleName()+
//                "]["+
//                joinPoint.getSignature().getName()+
//                "打印内容为"
//                +ano.value());
//    }

    @Around("pointcut() && @annotation(ano)")
    public Object advice(ProceedingJoinPoint joinPoint, Anno ano){
        System.out.println("打印内容为"+ano.value()+"---");
        System.out.println("注解作用的方法名" + joinPoint.getSignature().getName());
        System.out.println("所在类的简单类名" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("所在类的完整类名" + joinPoint.getSignature().getDeclaringType());
        System.out.println("目标方法的声明类型" + Modifier.toString(joinPoint.getSignature().getModifiers()));

        System.out.println("["+
                joinPoint.getSignature().getDeclaringType().getSimpleName()+
                "]["+
                joinPoint.getSignature().getName()+
                "打印内容为"
                +ano.value());

        Object result = null;

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i<args.length;i++){
            System.out.println(args[i]);
            if (args[i] instanceof Integer){
                args[i] = (Integer) args[i]-1;
                break;
            }
        }

        try{
            result = joinPoint.proceed(args);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

        if (result instanceof User){
            User user = (User) result;
            user.setId(user.getId() + 1);
            return user;
        }
        return result;
    }
}
