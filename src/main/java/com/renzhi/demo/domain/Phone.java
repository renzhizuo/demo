package com.renzhi.demo.domain;

import com.renzhi.demo.design.adapter.IVoltage5V;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone {
    private IVoltage5V voltage5V;

    public Phone(IVoltage5V voltage5V) {
        this.voltage5V = voltage5V;
    }

    public void charge(){
        log.info("手机开始充电");
        voltage5V.output5v();
    }
}
