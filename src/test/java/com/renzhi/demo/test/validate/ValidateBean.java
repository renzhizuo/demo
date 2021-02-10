package com.renzhi.demo.test.validate;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
@Data
@Accessors(chain = true)
public class ValidateBean {

    interface GroupA{}
    interface GroupB{}
    @GroupSequence({GroupA.class,GroupB.class})
    interface GroupC{}

    @Max(value = 10,groups = GroupA.class)
    private Integer id;
    @NotBlank
    private String name;
    @Length(min = 5,max = 10,groups =GroupA.class )
    private String email;

    @Max(value = 10,groups=GroupB.class)
    private Integer age;



}
