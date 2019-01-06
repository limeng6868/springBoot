package com.it.myspringboot.mapper;

import com.it.myspringboot.domian.Test;
import com.it.myspringboot.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author limeng
 * @date 2018/11/14 21:11
 */
    public interface UserRepository extends JpaRepository<Test,Long> {

    public List<Test> findAll();

}
