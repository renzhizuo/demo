package com.renzhi.demo.test.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String userId, String userName) {
        log.info("userId={},userName={}",userId, userName);
    }
}
