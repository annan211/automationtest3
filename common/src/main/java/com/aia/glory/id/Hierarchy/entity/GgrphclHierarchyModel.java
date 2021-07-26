package com.aia.glory.id.Hierarchy.entity;

import java.io.Serializable;

public class GgrphclHierarchyModel implements Serializable {

    private int ggrphclHierarchySeq;
    private String geographicalType;

    // contains(branch code,AR domicile code, area code)
    private String code;
    private int subChannel;
    private String subChannelName;
    private String dcDomicile;
    private String branchCode;
    private String areaCode;

    // alias on page :name
    private String longDesc;
    private String shortDesc;
    private int validFlag;
    private String address;
    private String city;
    private String province;
    private String postCode;
    private String email;
    private String telephoneNo;
    private String latitude;
    private String longitude;
    private String kppCode;
    private String reportingTo;
    private String createDate;
    private double versionLog;
    private String isLast;
    private String createBy;
    private String updateUser;
    private String effStartDate;
    private String effEndDate;
    private String lastUpdateBy;
    private String approveUser;
    private String key;

    public int getGgrphclHierarchySeq() {
        return ggrphclHierarchySeq;
    }

    public void setGgrphclHierarchySeq(int ggrphclHierarchySeq) {
        this.ggrphclHierarchySeq = ggrphclHierarchySeq;
    }

    public String getGeographicalType() {
        return geographicalType;
    }

    public void setGeographicalType(String geographicalType) {
        this.geographicalType = geographicalType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSubChannel() {
        return subChannel;
    }

    public void setSubChannel(int subChannel) {
        this.subChannel = subChannel;
    }

    public String getSubChannelName() {
        return subChannelName;
    }

    public void setSubChannelName(String subChannelName) {
        this.subChannelName = subChannelName;
    }

    public String getDcDomicile() {
        return dcDomicile;
    }

    public void setDcDomicile(String dcDomicile) {
        this.dcDomicile = dcDomicile;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public int getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(int validFlag) {
        this.validFlag = validFlag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getKppCode() {
        return kppCode;
    }

    public void setKppCode(String kppCode) {
        this.kppCode = kppCode;
    }

    public String getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(String reportingTo) {
        this.reportingTo = reportingTo;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public double getVersionLog() {
        return versionLog;
    }

    public void setVersionLog(double versionLog) {
        this.versionLog = versionLog;
    }

    public String getIsLast() {
        return isLast;
    }

    public void setIsLast(String isLast) {
        this.isLast = isLast;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getEffStartDate() {
        return effStartDate;
    }

    public void setEffStartDate(String effStartDate) {
        this.effStartDate = effStartDate;
    }

    public String getEffEndDate() {
        return effEndDate;
    }

    public void setEffEndDate(String effEndDate) {
        this.effEndDate = effEndDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
