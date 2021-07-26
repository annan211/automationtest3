package com.aia.glory.id.login.entity;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    private String loginId;

    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
