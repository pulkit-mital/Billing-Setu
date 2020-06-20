package com.billing.setu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Users {
    @Id
    private String id;
    private String customerName;
    private String mobileNumber;
    private List<String> refIds;

    public Users(String id, String customerName, String mobileNumber, List<String> refIds) {
        this.id = id;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.refIds = refIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<String> getRefIds() {
        return refIds;
    }

    public void setRefIds(List<String> refIds) {
        this.refIds = refIds;
    }
}
