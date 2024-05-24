package ru.gb.HW006.aspect;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Arrays;
import java.util.Objects;

@Component
@Aspect
public class ActionAspect {
    @Around(value = "@annotation(ru.gb.HW006.aspect.TrackUserAction)")
    public Object beforeMethodsService(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession s = (HttpSession) RequestContextHolder
                .currentRequestAttributes()
                .resolveReference(RequestAttributes.REFERENCE_SESSION);
        Object obj = joinPoint.proceed();
        System.out.println(s.getId() + " запустил метод: "
                + joinPoint.getSignature().getName() + " с аргументами "
                + Arrays.toString(joinPoint.getArgs()));
        return obj;
    }
}
