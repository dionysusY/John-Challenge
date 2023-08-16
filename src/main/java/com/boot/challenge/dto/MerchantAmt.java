package com.boot.challenge.dto;

public class MerchantAmt {


    private String merchant;
    private double total_amt;

    public MerchantAmt() {
    }

    public MerchantAmt(String merchant, double total_amt) {
        this.merchant = merchant;
        this.total_amt = total_amt;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }



}
