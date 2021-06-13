package com.renzhi.demo.design.observer;

/**
 * Description : 类描述
 * Created on : 2021-06-12
 * author : renzhi.zuo
 */

public class Client {
    public static void main(String[] args) {
        Subject subject = SubjectEnum.INSTANCE.getInstance();
        subject.addObserver(new ConcreteObserver());
        subject.addObserver(new SinaObserver());
        subject.addObserver(new BaiduObserver());

        subject.setChanged();
        subject.notifyObservers(new StartEvent().setId(1).setName("开始"));
        subject.setChanged();
        subject.notifyObservers(new EndEvent().setId(99).setName("结束"));
        subject.setChanged();
        subject.notifyObservers(new PauseEvent().setId(-1).setName("暂停"));
    }
}
