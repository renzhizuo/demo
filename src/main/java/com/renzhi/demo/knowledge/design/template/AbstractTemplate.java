package com.renzhi.demo.knowledge.design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Description : 类描述
 * Created on : 2021-06-05
 * author : renzhi.zuo
 */
@Slf4j
public abstract class AbstractTemplate {
    /**
     * 模版方法(算法骨架)，原则不让子类覆盖
     */
    final void make() {
        step1();
        if (need()) {
            step2();
        }
        step3();
        step4();
    }

    void step1() {
        log.info("步骤1");
    }

    /**
     * 抽象方法,需要子类实现
     */
    abstract void step2();

    void step3() {
        log.info("步骤3");
    }

    void step4() {
        log.info("步骤4");
    }

    /**
     * 钩子方法,子类重写，可以影响模版主方法的执行
     *
     * @return
     */
    boolean need() {
        return true;
    }
}
