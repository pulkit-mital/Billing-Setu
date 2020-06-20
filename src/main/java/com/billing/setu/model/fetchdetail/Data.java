package com.billing.setu.model.fetchdetail;

import java.util.Date;

public class Data {
    private String customerName;
    private double dueAmount;
    private Date dueDate;
    private String refID;

    public Data(String customerName, double dueAmount, Date dueDate, String refID) {
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.refID = refID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }
}
