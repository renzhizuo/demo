package com.renzhi.demo.design.template;

/**
 * Description : 类描述
 * Created on : 2021-06-05
 * author : renzhi.zuo
 *
 * @see org.springframework.context.ConfigurableApplicationContext#refresh()
 * 抽象方法 org.springframework.context.support.AbstractApplicationContext#obtainFreshBeanFactory()
 * 钩子方法                 this.postProcessBeanFactory(beanFactory);
 * this.onRefresh();
 */

public class TemplateClient {
    public static void main(String[] args) {
        AbstractTemplate template1 = new Template1();
        template1.make();

        AbstractTemplate template2 = new Template2();
        template2.make();
    }
}
