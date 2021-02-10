package com.renzhi.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Data
@Accessors(chain = true)
public class Message {
    private String msgId;
    private String message;
    private Integer type;
}
