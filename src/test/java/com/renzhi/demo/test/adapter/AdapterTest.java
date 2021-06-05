package com.renzhi.demo.test.adapter;

import com.renzhi.demo.knowledge.design.adapter.Voltage220V;
import com.renzhi.demo.knowledge.design.adapter.VoltageAdapter;
import com.renzhi.demo.knowledge.design.adapter.VoltageAdapter2;
import com.renzhi.demo.knowledge.design.adapter.interfaceadapter.AbsAdapter;
import com.renzhi.demo.knowledge.design.adapter.interfaceadapter.Interface;
import com.renzhi.demo.domain.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @see DispatcherServlet#doDispatch(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 * 1.获取控制器 handler
 * 2.根据handler获取adapter
 * 3.执行adapter方法
 *
 *  * 源码参考: @see org.springframework.web.servlet.DispatcherServlet#doDispatch(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 *  * // Determine handler for the current request.
 *  * mappedHandler = getHandler(processedRequest);
 *  * // Determine handler adapter for the current request.
 *  * HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
 */
@Slf4j
public class AdapterTest {

    @Test
    public void test() {
        Interface absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                log.info("m1实现");
            }
        };
        absAdapter.m1();
    }

    @Test
    public void test1() {
        Phone phone = new Phone(new VoltageAdapter());
        log.info("客户端充电开始,适配器1");
        phone.charge();
    }

    @Test
    public void test2() {
        Phone phone = new Phone(new VoltageAdapter2(new Voltage220V()));
        log.info("客户端充电开始,适配器2");
        phone.charge();
    }
}
