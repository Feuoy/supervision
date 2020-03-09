package com.supervision.service;


import com.supervision.entity.Record;
import java.util.List;


public interface Service {


    /**
     * 登录操作
     *
     * @param name
     * @param password
     * @return 如果存在这个该用户，true
     */
    boolean findUserByNameWithPassword(String name, String password);


    /**
     * 如果登录成功，记录
     *
     * @param userName
     */
    void insertRecord(String userName);


    /**
     * 查询记录
     *
     * @return 如果修改成功，true
     */
    List<Record> getRecordList();


    /**
     * 修改密码
     *
     * @param userName
     * @param password
     * @param newPassword
     * @return 如果修改成功，true
     */
    boolean ModifyPassword(String userName, String password, String newPassword);



    /*    *//**
     * 查询记录
     *
     * @return
     *//*
    List<Record> getRecordList();*/


}
