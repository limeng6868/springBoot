package com.it.myspringboot.annotation;

import java.lang.annotation.*;

/**
 * @author limeng
 * @date 2019/1/6 15:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MonitorRequest {

}
