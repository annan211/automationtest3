package com.aia.glory.id.model;

import java.io.Serializable;

public class Request implements Serializable {

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
