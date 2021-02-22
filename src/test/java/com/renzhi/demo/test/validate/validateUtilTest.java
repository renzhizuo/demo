package com.renzhi.demo.test.validate;

import cn.hutool.extra.validation.BeanValidationResult;
import cn.hutool.extra.validation.ValidationUtil;
import com.alibaba.fastjson.JSON;
import com.renzhi.demo.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Slf4j
public class validateUtilTest extends BaseTest {
    @Test
    public void test(){
        ValidateBean validateBean = new ValidateBean().setId(7).setName("张三").setEmail("11111111111@qq.com");
        Set<ConstraintViolation<ValidateBean>> constraintViolations = ValidationUtil.validate(validateBean);
        StringBuilder stringBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            constraintViolations.forEach(t->stringBuilder.append(t.getMessage()));
        }
        log.info("stringBuilder={}",stringBuilder);

    }

    @Test
    public void testGroup(){
        ValidateBean validateBean = new ValidateBean().setId(7).setName("张三").setEmail("11111111111@qq.com");
        Set<ConstraintViolation<ValidateBean>> constraintViolations = ValidationUtil.validate(validateBean, ValidateBean.GroupA.class);
        StringBuilder stringBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            constraintViolations.forEach(t->stringBuilder.append(t.getMessage()));
        }
        log.info("stringBuilder={}",stringBuilder);
    }

    @Test
    public void testGroupSequence(){
        ValidateBean validateBean = new ValidateBean().setId(7).setName("张三").setEmail("11111111111@qq.com");
        BeanValidationResult beanValidationResult = ValidationUtil.warpValidate(validateBean, ValidateBean.GroupC.class);
        if (!beanValidationResult.isSuccess()) {
            log.info("beanValidationResult={}", JSON.toJSONString(beanValidationResult));
        }
    }
}
