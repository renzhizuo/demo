package com.renzhi.demo.test.proxy.handle;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTimeHandler implements MethodInterceptor {
    private Object targetObj;

    public CglibTimeHandler(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法之前：" + System.currentTimeMillis());
        Object ret = methodProxy.invoke(targetObj, objects);
        System.out.println("方法之后：" + System.currentTimeMillis());
        return ret;
    }

}
