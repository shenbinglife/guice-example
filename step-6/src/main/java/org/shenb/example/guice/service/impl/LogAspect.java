package org.shenb.example.guice.service.impl;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.shenb.example.guice.service.HelloService;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
public class LogAspect implements MethodInterceptor {

    @Inject
    private HelloService helloService;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String methodName = methodInvocation.getMethod().getName();
        System.out.println("log before method [" + methodName + "] exec");
        try {
            return methodInvocation.proceed();
        } catch (Exception e) {
            System.out.println("log exception");
            throw new RuntimeException(e);
        } finally {
            System.out.println("log after method[" + methodName + "] exec");
            helloService.bye();
        }
    }
}
