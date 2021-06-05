package com.renzhi.demo.knowledge.design.template;

/**
 * Description : 类描述
 * Created on : 2021-06-05
 * author : renzhi.zuo
 */

public class Template2 extends AbstractTemplate{
    @Override
    void step2() {
        System.out.println("Template2 step2");
    }

    @Override
    boolean need() {
        return false;
    }
}
