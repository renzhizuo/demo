package com.renzhi.demo.test.listener;

import com.renzhi.demo.domain.Message;
import com.renzhi.demo.listener.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@SpringBootTest
@Slf4j
public class ListenerTest {
    @Resource
    private List<MessageListener> messageListenerList;

    @Test
    public void test(){
        Message message = new Message().setType(2);
        messageListenerList.stream().filter(t->t.accept(message)).forEach(t->t.onMessage(message));
    }
}
