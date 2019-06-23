package com.sc.concurrency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: shichao
 * @date: 2019/6/23
 * @description: 测试的Controller
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String Test() {
        System.out.println("test invoker.....");
        return "hello!";
    }
}
