package com.sc.concurrency.config;

import com.sc.concurrency.HttpFilter;
import com.sc.concurrency.HttpInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:
 */
@Configuration
public class BeanConfig extends WebMvcConfigurerAdapter {


    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HttpFilter());
        filterRegistrationBean.addUrlPatterns("/threadLocal/*");
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
