package com.it.myspringboot.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.myspringboot.MyspringbootApplication;
import com.it.myspringboot.mapper.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author limeng
 * @date 2018/11/13 16:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyspringbootApplication.class)
public class MapperTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {

        String userListData = redisTemplate.boundValueOps("user").get();
            //如果redis中没有数据的话
        if(null==userListData){
                //查询数据库获得数据
            List<com.it.myspringboot.domian.Test> all = userRepository.findAll();
                //转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            try {
                userListData = om.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
                //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("user").set(userListData);
            System.out.println("===============从数据库获得数据===============");
        }else{
            System.out.println("===============从redis缓存中获得数据===============");
        }
        System.out.println(userListData);
    }

    }

