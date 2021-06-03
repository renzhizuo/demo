package com.renzhi.demo.controller;

import com.renzhi.demo.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("demo")
    public Response test(){
        return Response.success();
    }
}
