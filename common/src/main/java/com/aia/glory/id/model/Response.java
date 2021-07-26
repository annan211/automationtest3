package com.aia.glory.id.model;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private String responseCode;

    private List reasonCode;

    private List reasonDesc;

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
}
