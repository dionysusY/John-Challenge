package com.boot.challenge.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transactions {
    @Id
    private long trans_num = -1;

    String transDateTransTime;

    double amt;

    long customId;
    String city;
    String state;
    int cityPopulation;
    String merchant;
    String category;
    String first;
    String last;
    String gender;
    String job;
    String dob;

    public Transactions() {
    }

    public Transactions(String transDateTransTime, double amt, long customId, String city, String state, int cityPopulation, String merchant, String category, String first, String last, String gender, String job, String dob) {
        this.transDateTransTime = transDateTransTime;
        this.amt = amt;
        this.customId = customId;
        this.city = city;
        this.state = state;
        this.cityPopulation = cityPopulation;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    public long getTrans_num() {
        return trans_num;
    }

    public void setTrans_num(long trans_num) {
        this.trans_num = trans_num;
    }

    public String getTransDateTransTime() {
        return transDateTransTime;
    }

    public void setTransDateTransTime(String transDateTransTime) {
        this.transDateTransTime = transDateTransTime;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public long getCustomId() {
        return customId;
    }

    public void setCustomId(long customId) {
        this.customId = customId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "trans_num=" + trans_num +
                ", transDateTransTime='" + transDateTransTime + '\'' +
                ", amt=" + amt +
                ", customId=" + customId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cityPopulation=" + cityPopulation +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
