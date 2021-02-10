package com.renzhi.demo.listener;

import com.renzhi.demo.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Description : Order控制执行顺序，不是加载顺序
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Service
@Order(1)
@Slf4j
public class StartMessageListener implements MessageListener {
    @Override
    public Boolean accept(Message message) {
        return message.getType() > 1;
    }

    @Override
    public void onMessage(Message message) {
log.info("开始");
    }
}
