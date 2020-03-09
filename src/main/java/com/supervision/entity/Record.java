package com.supervision.entity;

import com.google.common.base.Objects;

import java.util.Date;

public class Record {

    private long recordID;
    private String userName;
    private Date loginTime;


    public long getRecordID() {
        return recordID;
    }

    public void setRecordID(long recordID) {
        this.recordID = recordID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }


    /*toStringHelper*/
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("recordID", recordID)
                .add("userName", userName)
                .add("loginTime", loginTime)
                .toString();
    }

}
