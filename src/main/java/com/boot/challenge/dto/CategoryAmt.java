package com.boot.challenge.dto;

public class CategoryAmt {


    private String category;
    private double total_amt;

    public CategoryAmt() {
    }

    public CategoryAmt(String category, double total_amt) {
        this.category = category;
        this.total_amt = total_amt;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String merchant) {
        this.category = category;
    }



}
