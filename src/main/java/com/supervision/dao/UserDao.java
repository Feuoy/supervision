package com.supervision.dao;

import org.apache.ibatis.annotations.Param;
import com.supervision.entity.User;


public interface UserDao {


    /**
     * 根据用户名和密码查询
     *
     * @param name
     * @param password
     * @return
     */
    User queryByNameWithPassword(@Param("name") String name,
                                 @Param("password") String password);


    /**
     * 更新密码
     *
     * @param name
     * @param password
     * @param newPassword
     * @return
     */
    int updatePassword(@Param("name") String name,
                       @Param("password") String password,
                       @Param("newPassword") String newPassword);
}
