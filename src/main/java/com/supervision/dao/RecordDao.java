package com.supervision.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.supervision.entity.Record;


public interface RecordDao {


    /**
     * 插入记录，可过滤重复
     *
     * @param userName
     * @return 如果成功，1
     */
    int insert(String userName);


    /**
     * 查询所有方式存
     *
     * @return
     */
    List<Record> getList();



    /*    *//**
     * 根据偏移量查询
     *
     * @param offset
     * @param limit
     * @return
     *
     * java没有保存形参的记录，所以offset与limit会被作为arg0,arg1传递，导致出错，
     * 用mybatis自带的@Param注解进行转义
     *//*
    List<Record> queryAll(@Param("offset") int offset,
                          @Param("limit") int limit);*/
}
