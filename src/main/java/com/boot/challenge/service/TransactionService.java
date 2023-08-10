package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ccc
 * @date 2023/8/10 - 0:00
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;

    public List<Transactions> getTransactionByCity(String city){
        return transactionDAO.findTransactionsByCity(city);
    }

    public List<Transactions> getTransactionByState(String state) {
        return transactionDAO.findTransactionsByState(state);
    }

    public List<Transactions> getTransactionsByGender(String gender) {
        return transactionDAO.findTransactionsByGender(gender);
    }

    public List<Transactions> getTsansactionsByMerchant(String merchant){
        return transactionDAO.findTransactionsByMerchant(merchant);
    }
}
