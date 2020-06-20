package com.billing.setu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class PaymentDetails {
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    @Id
    private String refId;
    private String ackId;
    private double dueAmount;
    private Date dueDate;
    private boolean isPaymentDone;

    public PaymentDetails(String id, String refId, String ackId, double dueAmount, Date dueDate, boolean isPaymentDone) {
        this.id = id;
        this.refId = refId;
        this.ackId = ackId;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.isPaymentDone = isPaymentDone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getAckId() {
        return ackId;
    }

    public void setAckId(String ackId) {
        this.ackId = ackId;
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

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean isPaymentDone) {
        this.isPaymentDone = isPaymentDone;
    }
}
