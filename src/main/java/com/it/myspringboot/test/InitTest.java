package com.it.myspringboot.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author limeng
 * @date 2019/1/5 21:07
 */
@Configuration
public class InitTest implements BeanPostProcessor {
    @PostConstruct
    public void test(){


        System.out.println("-----------------------------test1");

    }

}
