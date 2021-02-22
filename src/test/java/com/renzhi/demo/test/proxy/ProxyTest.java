package com.renzhi.demo.test.proxy;

import cn.hutool.aop.ProxyUtil;
import com.renzhi.demo.BaseTest;
import com.renzhi.demo.test.proxy.handle.CglibTimeHandler;
import com.renzhi.demo.test.proxy.handle.LogHandler;
import com.renzhi.demo.test.proxy.handle.TimeHandler;
import org.junit.jupiter.api.Test;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */

public class ProxyTest extends BaseTest {

    @Test
    public void test(){
        UserService userService = new UserServiceImpl();

        LogHandler logHandler = new LogHandler(userService);
        //一层代理
        userService=ProxyUtil.newProxyInstance(userService.getClass().getClassLoader(),logHandler,
                userService.getClass().getInterfaces());

        TimeHandler timeHandler = new TimeHandler(userService);
        //二层代理?
        userService=ProxyUtil.newProxyInstance(userService.getClass().getClassLoader(),timeHandler,
                userService.getClass().getInterfaces());

        userService.addUser("1111", "张三");    }

}
