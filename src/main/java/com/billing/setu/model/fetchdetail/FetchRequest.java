package com.billing.setu.model.fetchdetail;

public class FetchRequest {

    private String mobileNumber;

    public FetchRequest() {
    }

    public FetchRequest(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
