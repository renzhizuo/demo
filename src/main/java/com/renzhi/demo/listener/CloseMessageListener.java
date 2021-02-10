package com.renzhi.demo.listener;

import com.renzhi.demo.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Service
@Slf4j
public class CloseMessageListener implements MessageListener, Ordered {
    @Override
    public Boolean accept(Message message) {
        return message.getType() > 1;
    }

    @Override
    public void onMessage(Message message) {
        log.info("结束");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
