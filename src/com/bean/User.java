package com.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String UserNumber;
    private String UserPassword;
    private String UserName;

    public User() {
        super();
    }

    public String getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(String userNumber) {
        this.UserNumber = userNumber;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        this.UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }
}
