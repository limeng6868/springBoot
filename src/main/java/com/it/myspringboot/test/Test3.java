package com.it.myspringboot.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author limeng
 * @date 2019/1/5 21:12
 */
@Configuration
public class Test3 implements BeanPostProcessor {



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("--------------------------------test3");

        return bean;

    }

    @Override

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("test3--------------------------------");

        return bean;

    }


}
