package com.aia.glory.id.login.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private int roleId;

    private String roleName;

    private String authority;

    private String remark;

    private List<SecurityUser> userlist;

    private String action;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SecurityUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<SecurityUser> userlist) {
        this.userlist = userlist;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
