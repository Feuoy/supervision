package com.supervision.dao;

import com.supervision.entity.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/*
 * 配置spring与junit整合，junit启动加载springIOC容器
 * ctrl+shift+t创建
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RecordDaoTest {



    /*注入dao实现类*/
    @Autowired
    private RecordDao recordDao;



    @Test
    public void insert() throws Exception {
        String userName = "学生甲";
        int isSuccess  = recordDao.insert(userName);
        System.out.println("row:  " + isSuccess);
    }



    @Test
    public void getList() throws Exception {
        List<Record> list  = recordDao.getList();
        System.out.println("list:  " + list);
    }



/*    @Test
    public void queryAll() throws Exception {
        List<Record> records = recordDao.queryAll(0, 5);
        for (Record record : records) {
            System.out.println("record: " + record);
        }
    }*/


}
