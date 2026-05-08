package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    // 定义切点 第一个星表示返回类型  第二个星表示方法名  第三个星表示参数名
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("自动填充参数");

        // 从参数中获取操作类型
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//获取方法签名
        AutoFill autoFill = methodSignature.getMethod().getAnnotation(com.sky.annotation.AutoFill.class);
        OperationType operationType = autoFill.value();

        //准备填入的参数
        Long userId = BaseContext.getCurrentId();
        LocalDateTime now = LocalDateTime.now();

        //取出对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        // 根据操作类型填充参数
        if (operationType == OperationType.INSERT) {
            // 插入操作 4条
            try {
                //创建
                Method setCreateTimeMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUserMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                //更新
                Method setUpdateTimeMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUserMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                //用反射赋值
                setCreateTimeMethod.invoke(entity, now);
                setCreateUserMethod.invoke(entity, userId);
                setUpdateTimeMethod.invoke(entity, now);
                setUpdateUserMethod.invoke(entity, userId);

                //log.info("自动填充参数成功,entity={}", entity);

            } catch (Exception e) {
                log.error("自动填充参数失败", e);
                throw new RuntimeException(e);
            }
        } else if (operationType == OperationType.UPDATE) {
            // 更新操作 2条
            try {
                //更新
                Method setUpdateTimeMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUserMethod = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                //用反射赋值
                setUpdateTimeMethod.invoke(entity, now);
                setUpdateUserMethod.invoke(entity, userId);

                //log.info("自动填充参数成功,entity={}", entity);

            } catch (Exception e) {
                log.error("自动填充参数失败", e);
                throw new RuntimeException(e);
            }
        }
    }
}