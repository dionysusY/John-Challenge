package com.boot.challenge.dto;

public class GenderAmt {
    private String gender;
    private double total_amt;

    public GenderAmt() {
    }

    public GenderAmt(String gender, double total_amt) {
        this.gender = gender;
        this.total_amt = total_amt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }

}
