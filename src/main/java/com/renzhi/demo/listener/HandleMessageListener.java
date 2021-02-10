package com.renzhi.demo.listener;

import com.renzhi.demo.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Service
@Order(2)
@Slf4j
public class HandleMessageListener implements MessageListener {
    @Override
    public Boolean accept(Message message) {
        return message.getType() > 2;
    }

    @Override
    public void onMessage(Message message) {
        log.info("执行");
    }
}
