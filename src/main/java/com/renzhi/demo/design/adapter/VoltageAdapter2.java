package com.renzhi.demo.design.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 1)	对象适配器和类适配器其实算是同一种思想，只不过实现方式不同。
 * 根据合成复用原则，使用组合替代继承， 所以它解决了类适配器必须继承 src 的局限性问题，也不再要求 dst
 * 必须是接口。
 *
 * 2)	使用成本更低，更灵活。
 */
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
