package com.renzhi.demo.test.adapter;

import com.renzhi.demo.design.adapter.Voltage220V;
import com.renzhi.demo.design.adapter.VoltageAdapter;
import com.renzhi.demo.design.adapter.VoltageAdapter2;
import com.renzhi.demo.domain.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class AdapterTest  {
    @Test
    public void test(){
        Phone phone = new Phone(new VoltageAdapter());
        log.info("客户端充电开始,适配器1");
        phone.charge();
    }

    @Test
    public void test2(){
        Phone phone = new Phone(new VoltageAdapter2(new Voltage220V()));
        log.info("客户端充电开始,适配器2");
        phone.charge();
    }
}
