package com.supervision.service;

import com.supervision.dao.UserDao;
import com.supervision.dao.RecordDao;

import com.supervision.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.supervision.usage.Sha1.getSha1;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {



    //注入service依赖
    @Autowired
    private UserDao userDao;
    @Autowired
    private RecordDao recordDao;



    public boolean findUserByNameWithPassword(String name, String password){
        return userDao.queryByNameWithPassword(name, getSha1(password)) != null;
    }



    public void insertRecord(String userName){
        recordDao.insert(userName);
    }



    public boolean ModifyPassword(String userName, String password, String newPassword){
        return userDao.updatePassword(userName , getSha1(password), getSha1(newPassword)) > 0;
    }



    public List<Record> getRecordList(){
        return recordDao.getList();
    }



/*    public List<Record> getRecordList() {
        return recordDao.queryAll(0, 10);
    }*/


}
