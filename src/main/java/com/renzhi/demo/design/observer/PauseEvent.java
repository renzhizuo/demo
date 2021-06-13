package com.renzhi.demo.design.observer;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description : 类描述
 * Created on : 2021-06-13
 * author : renzhi.zuo
 */
@Data
@Accessors(chain = true)
public class PauseEvent {
    private int id;
    private String name;
}
