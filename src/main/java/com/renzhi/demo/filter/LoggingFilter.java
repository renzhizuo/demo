package com.renzhi.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * Description : 类描述
 * Created on : 2021-05-13
 * author : renzhi.zuo
 */
@Slf4j
@Component
public class LoggingFilter extends CommonsRequestLoggingFilter {
    @Value("${log.request:true}")
    private boolean logRequest;
    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return logRequest;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info("beforeRequest-{}",message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
    }

    @Override
    public void setMaxPayloadLength(int maxPayloadLength) {
        super.setMaxPayloadLength(50);
    }

    @Override
    protected boolean isIncludeQueryString() {
        return true;
    }

    @Override
    protected boolean isIncludeClientInfo() {
        return true;
    }

    @Override
    protected boolean isIncludeHeaders() {
        return true;
    }

    @Override
    protected boolean isIncludePayload() {
        return true;
    }
}
