package com.supervision.entity;

import com.google.common.base.Objects;

import java.util.Date;

public class User {


    private long userID;
    private String name;
    private String password;
    private Date createTime;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    /*toStringHelper*/
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("userID", userID)
                .add("name", name)
                .add("password", password)
                .add("createTime", createTime)
                .toString();
    }


}
