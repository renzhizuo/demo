package com.renzhi.demo.design.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5v() {
        int src = output220V();
        log.info("原电压{}V", src);
        int out = src / 44;
        log.info("适配后{}V", out);
        return out;
    }
}
