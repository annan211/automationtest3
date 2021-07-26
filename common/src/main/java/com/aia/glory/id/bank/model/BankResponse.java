package com.aia.glory.id.bank.model;

import com.aia.glory.id.model.Response;
import com.aia.glory.id.model.ResponseCode;

import java.util.Arrays;

public class BankResponse extends Response {
    private Object bank;
    private int total;
    public Object getBank() {
        return bank;
    }

    public void setBank(Object bank) {
        this.bank = bank;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
