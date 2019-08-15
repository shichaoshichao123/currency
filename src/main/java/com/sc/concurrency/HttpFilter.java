package com.sc.concurrency;

import com.sc.concurrency.threadLocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:
 */
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //进行ThreadLocal操作
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("do filter id:"+Thread.currentThread().getId() +"path:"+httpServletRequest.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
