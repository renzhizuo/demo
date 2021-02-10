package com.renzhi.demo.listener;

import com.renzhi.demo.domain.Message;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */

public interface MessageListener {
    Boolean accept(Message message);

    void onMessage(Message message);
}
