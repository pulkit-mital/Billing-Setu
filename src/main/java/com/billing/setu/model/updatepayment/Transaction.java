package com.billing.setu.model.updatepayment;

import java.util.Date;

public class Transaction {
    private double amountPaid;
    private Date date;
    private String id;

    public Transaction() {
    }

    public Transaction(double amountPaid, Date date, String id) {
        this.amountPaid = amountPaid;
        this.date = date;
        this.id = id;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
