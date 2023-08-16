package com.boot.challenge.dto;

public class StateAmt {
    private String state;
    private double total_amt;

    public StateAmt() {
    }

    public StateAmt(String state, double total_amt) {
        this.state = state;
        this.total_amt = total_amt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
