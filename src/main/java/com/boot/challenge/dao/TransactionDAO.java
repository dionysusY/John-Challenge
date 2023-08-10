package com.boot.challenge.dao;

import com.boot.challenge.entity.Transactions;

import java.util.List;

/**
 * @ccc
 * @date 2023/8/9 - 23:34
 */
public interface TransactionDAO {

    List<Transactions> findTransactionsByCity(String city);

    List<Transactions> findTransactionsByState(String state);

}