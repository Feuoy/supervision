package com.supervision.dao;

import com.supervision.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.supervision.usage.Sha1.getSha1;


/*
 * 配置spring与junit整合，junit启动加载springIOC容器
 * */
@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class UserDaoTest {


    /*注入dao实现类*/
    @Autowired
    private UserDao userDao;


    @Test
    public void queryByNameWithPassword() throws Exception {
        String name = "学生甲";
        String password = getSha1("123456");
        User user = userDao.queryByNameWithPassword(name, password);
        System.out.println("user: " + user);
    }


    @Test
    public void updatePassword() throws Exception {
        String name = "学生甲";
        String password = getSha1("123456");
        String newPassword = getSha1("123");
        int isSuccess = userDao.updatePassword(name, password, newPassword);
        System.out.println("isSuccess: " + isSuccess);
    }


}
