package com.aia.glory.id.position.entity;

import com.aia.glory.id.model.Response;
import com.aia.glory.id.model.ResponseCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class GetPositionRelationResponse extends Response  {

    private Object positionRelationList;

    private int total;

    public Object getPositionRelationList() {
        return positionRelationList;
    }

    public void setPositionRelationList(Object positionRelationList) {
        this.positionRelationList = positionRelationList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "GetPositionRelationResponse [positionRelationList=" + positionRelationList + ", total=" + total + "]" + super.toString();
    }
}
