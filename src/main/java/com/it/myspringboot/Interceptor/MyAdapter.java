package com.it.myspringboot.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 继承WebMvcConfigureAdapter继承并重写addInterceptor方法用于添加配置拦截器
 * @author limeng
 * @date 2019/1/5 19:05
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }


}
