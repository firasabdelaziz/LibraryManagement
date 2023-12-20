package com.example.preexamn.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AOP {

    @AfterReturning(pointcut = "execution(* com.example.preexamn.services..*.*(..)) && args(..)", returning = "result")
    public void logAfterReturning(Object result) {
        if (result != null && result instanceof String) {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            if (methodName.startsWith("add")) {
                log.info("Ajouté avec succès");
            }
        }
    }
}
