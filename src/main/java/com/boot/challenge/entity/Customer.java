package com.boot.challenge.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Customer {
    @Transient
    public static String generateSequenceName = "customer";

    @Id
    private long customerID = -1;

    private String first;
    private String last;
    private String gender;
    private String job;
    private Date dob;

    private int valid;

    public Customer(long customerID, String first, String last, String gender, String job, Date dob,int valid) {
        this.customerID = customerID;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
        this.valid = valid;
    }

    public Customer(String first, String last, String gender, String job, Date dob) {
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    public Customer() {
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob=" + dob +
                '}';
    }
}
