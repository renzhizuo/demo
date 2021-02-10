package com.renzhi.demo.test.hutool;

import cn.hutool.Hutool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@SpringBootTest
@Slf4j
public class HutoolTest {

    @Test
    public void test(){
        printAllUtils();
    }

    private static void printAllUtils() {
        final Set<Class<?>> allUtils = Hutool.getAllUtils();
        for (Class<?> clazz : allUtils) {
            log.info("工具类名={},所在包={}",clazz.getSimpleName(),clazz.getPackage().getName());
        }
    }
}
