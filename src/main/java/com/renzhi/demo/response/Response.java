package com.renzhi.demo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;

/**
 * Description : 类描述
 * Created on : 2021-05-13
 * author : renzhi.zuo
 */

@ApiModel(description = "chat返回实体封装")
@Data
public class Response<T> {

    @ApiModelProperty(value = "响应码", required = true, example = "10000")
    private String code;
    @ApiModelProperty(value = "响应消息", required = true, example = "请求成功")
    private String message;
    @ApiModelProperty(value = "返回数据", example = "{}")
    private T data;

    public Response() {
    }

    private Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(ResultCodeEnum.OK.getCode(), ResultCodeEnum.OK.getMsg());
    }

    public static <T> Response<T> success(T t) {
        return new Response<>(ResultCodeEnum.OK.getCode(), ResultCodeEnum.OK.getMsg(), t);
    }

    public static <T> Response<T> fail() {
        return new Response<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static Boolean isSuccess(Response response) {
        return Optional.ofNullable(response).map(t -> Objects.equals(ResultCodeEnum.OK.getCode(), t.getCode())).orElse(false);
    }


    enum ResultCodeEnum {

        /**
         * 请求成功
         */
        OK("10000", "请求成功"),
        /**
         * 请求失败
         */
        FAIL("20001", "错误");

        private String code;
        private String msg;

        ResultCodeEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public String getCode() {
            return code;
        }
    }
}