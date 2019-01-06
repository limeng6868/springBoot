package com.it.myspringboot.controller;

import com.it.myspringboot.domian.User;
import com.it.myspringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author limeng
 * @date 2018/11/13 15:59
 */
@Controller
public class MapperController {


    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryUser")
    @ResponseBody
    public  List<User> queryUser(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

    @RequestMapping("/query")
    @ResponseBody
    public  String query(){

        return "6666666666666";
    }


}
