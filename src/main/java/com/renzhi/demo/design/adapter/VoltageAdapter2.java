package com.renzhi.demo.design.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VoltageAdapter2 implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter2(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5v() {
        int src = voltage220V.output220V();
        log.info("原电压{}V", src);
        int out = src / 44;
        log.info("适配后{}V", out);
        return out;
    }
}
