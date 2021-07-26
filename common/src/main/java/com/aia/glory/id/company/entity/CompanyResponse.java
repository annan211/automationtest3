package com.aia.glory.id.company.entity;

import com.aia.glory.id.model.Response;
import com.aia.glory.id.model.ResponseCode;

import java.util.Arrays;

public class CompanyResponse extends Response {
    private Object company;

    private int total;

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CompanyInfomationResponse [company=" + company + "]" + super.toString();
    }

}
