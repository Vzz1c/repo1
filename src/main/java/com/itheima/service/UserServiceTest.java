package com.itheima.service;

import com.itheima.bean.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author 王磊
 * @Date 2019/6/14/014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationConfig-mvc.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService ;

    @org.junit.Test
    public void findAll() {
        List<User> users = userService.findAll();
        System.out.println(users);

    }
}