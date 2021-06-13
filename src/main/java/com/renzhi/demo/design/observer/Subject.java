package com.renzhi.demo.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Description : 类描述
 * Created on : 2021-06-12
 * author : renzhi.zuo
 */

public class Subject extends Observable {
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }


    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

}
