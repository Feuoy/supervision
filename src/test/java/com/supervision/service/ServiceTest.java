package com.supervision.service;

import com.supervision.entity.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-services.xml"
})
public class ServiceTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTest.class);

    @Autowired
    private Service service;


    @Test
    public void findUserByNameWithPassword() throws Exception {
        String name = "学生甲";
        String password = "123456";
        boolean isUser = service.findUserByNameWithPassword(name,password);
        LOGGER.info("isUser: " + isUser);
    }


    @Test
    public void insertRecord() throws Exception {
        List<Record> list = service.getRecordList();
        LOGGER.info("list: " + list);

        String name = "学生甲";
        service.insertRecord(name);
        LOGGER.info("insertRecord.");

        list = service.getRecordList();
        LOGGER.info("list: " + list);
    }


    @Test
    public void getRecordList() throws Exception {
        List<Record> list = service.getRecordList();
        LOGGER.info("list: " + list);
    }


    @Test
    public void ModifyPassword() throws Exception {
        String userName = "学生甲";
        String password = "123456";
        String newPassword = "123456";
        boolean isSuccess = service.ModifyPassword(userName, password, newPassword);
        LOGGER.info("isSuccess: " + isSuccess);
    }
}