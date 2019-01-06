package com.it.myspringboot.mapper;

import com.it.myspringboot.domian.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author limeng
 * @date 2018/11/13 15:55
 */
@Mapper
public interface UserMapper {


    public List<User> queryUserList();

}
