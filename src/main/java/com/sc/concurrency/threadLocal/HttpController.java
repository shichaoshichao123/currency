package com.sc.concurrency.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:
 */
@Controller
@RequestMapping("/threadLocal")
public class HttpController {


    @RequestMapping("/getThreadId")
    @ResponseBody
    public Long getThreadId(){

        return RequestHolder.get();

    }
}
