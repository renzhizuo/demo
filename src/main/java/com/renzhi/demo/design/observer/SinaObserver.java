package com.renzhi.demo.design.observer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * Description : 类描述
 * Created on : 2021-06-12
 * author : renzhi.zuo
 */
@Slf4j
public class SinaObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof EndEvent) {
            log.info("处理EndEvent事件,参数:{}", JSON.toJSONString(arg));
        }
    }
}
