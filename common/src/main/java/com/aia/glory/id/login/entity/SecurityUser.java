package com.aia.glory.id.login.entity;

import java.io.Serializable;
import java.util.List;

public class SecurityUser implements Serializable {

    private String loginId;

    private String username;

    private String remark;

    private String enabled;

    private String email;

    private String businessunit;

    private String processingunit;

    private List<Role> rolelist;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessunit() {
        return businessunit;
    }

    public void setBusinessunit(String businessunit) {
        this.businessunit = businessunit;
    }

    public String getProcessingunit() {
        return processingunit;
    }

    public void setProcessingunit(String processingunit) {
        this.processingunit = processingunit;
    }

    public List<Role> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<Role> rolelist) {
        this.rolelist = rolelist;
    }
}
