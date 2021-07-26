package com.aia.glory.id.Hierarchy.entity;

import com.aia.glory.id.model.Response;

import java.util.List;

public class GgHierarchyResponse  extends Response {


    private List<GgrphclHierarchyModel> ggrphclHierarchyModelList;

    private int total;

    public int getTotal() { return total; }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<GgrphclHierarchyModel> getGgrphclHierarchyModelList() {
        return ggrphclHierarchyModelList;
    }

    public void setGgrphclHierarchyModelList(List<GgrphclHierarchyModel> ggrphclHierarchyModelList) {
        this.ggrphclHierarchyModelList = ggrphclHierarchyModelList;
    }
}
