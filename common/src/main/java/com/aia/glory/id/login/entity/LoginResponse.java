package com.aia.glory.id.login.entity;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {

    private String responseCode;

    private List reasonCode;

    private List reasonDesc;

    private Token token;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(List reasonCode) {
        this.reasonCode = reasonCode;
    }

    public List getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(List reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
