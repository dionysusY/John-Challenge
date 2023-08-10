package com.boot.challenge.dto;

import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;

import java.util.List;

public class PageResponse {
    int totalPages;
    long totalElements;
    int noofelements ;
    int pagesize ;
    List<Transactions> transactions;

    List<Customer> customers;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNoofelements() {
        return noofelements;
    }

    public void setNoofelements(int noofelements) {
        this.noofelements = noofelements;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
