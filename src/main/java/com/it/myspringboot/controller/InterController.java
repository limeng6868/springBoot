package com.it.myspringboot.controller;

import com.it.myspringboot.annotation.MonitorRequest;
import com.it.myspringboot.domian.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limeng
 * @date 2019/1/5 19:10
 */
@RestController
@RequestMapping("/inter")
public class InterController {
//    @RequestMapping("/test")
//    public void test(HttpServletResponse response) throws IOException {
//        response.getWriter().print("<h1>Hello interceptor test</h1>");
//    }

    @MonitorRequest
    @RequestMapping(value = "/test")
    public String test(@RequestBody User user){
        return "method be added @MonitorRequest";
    }

}
