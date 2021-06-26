package com.renzhi.demo.design.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * ###适配器模式的注意事项和细节
 * 1)三种命名方式，是根据 src 是以怎样的形式给到 Adapter（在 Adapter 里的形式）来命名的。
 * 2)类适配器：以类给到，在 Adapter 里，就是将 src 当做类， 继承
 * 对象适配器：以对象给到，在 Adapter 里，将 src 作为一个对象，持有
 * 接口适配器：以接口给到，在 Adapter 里，将 src 作为一个接口，实现
 * <p>
 * 举例：
 * 已有220v电压充电插座（圆孔）
 * 已有一个国标5v充电器(片孔)
 * 现需要一个变压器(适配器),将圆孔转为片孔插座，可供手机充电
 */
@Slf4j
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    /**
     * 1)	Java 是单继承机制，所以类适配器需要继承 src 类这一点算是一个缺点, 因为这要求 dst 必须是接口，有一定局限性;
     * 2)	src 类的方法在 Adapter 中都会暴露出来，也增加了使用的成本。
     * 3)	由于其继承了 src 类，所以它可以根据需求重写 src 类的方法，使得 Adapter 的灵活性增强了。
     * @return
     */
    @Override
    public int output5v() {
        int src = output220V();
        log.info("原电压{}V", src);
        int out = src / 44;
        log.info("适配后{}V", out);
        return out;
    }
}
