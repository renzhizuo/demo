package com.renzhi.demo.test.proxy.handle;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class LogHandler implements InvocationHandler {
    private Object targetObj;

    public LogHandler(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        try {
            log.info("调用前:{}",System.currentTimeMillis());
            invoke = method.invoke(targetObj, args);
            if (Objects.nonNull(invoke)) {
                log.info("调用后,结果:{}", invoke.toString());
            } else {
                log.info("调用后:{}",System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("LogHandler.invoke出错", e);
            throw e;
        }
        return invoke;
    }
}
