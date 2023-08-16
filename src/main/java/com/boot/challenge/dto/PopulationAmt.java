package com.boot.challenge.dto;

public class PopulationAmt {
    private int city_population;
    private double total_amt;

    public PopulationAmt() {
    }

    public PopulationAmt(int city_population, double total_amt) {
        this.city_population = city_population;
        this.total_amt = total_amt;
    }

    public int getCityPopulation() {
        return city_population;
    }

    public void setCityPopulation(int city_population) {
        this.city_population = city_population;
    }
    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
