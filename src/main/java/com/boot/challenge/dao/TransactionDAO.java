package com.boot.challenge.dao;

import com.boot.challenge.dto.MerchantAmt;
import com.boot.challenge.entity.Transactions;

import java.util.List;

/**
 * @ccc
 * @date 2023/8/9 - 23:34
 */
public interface TransactionDAO {

    List<Transactions> findTransactionsByCity(String city);

    List<Transactions> findTransactionsByState(String state);
    List<Transactions> findTransactionsByGender(String gender);

    List<Transactions> findTransactionsByMerchant(String merchant);

    List<Transactions> findTransactionsByAmount(int sort,int pageNo,int size);

    List<Transactions> findTransactionsByCategory(String category);

    List<Transactions> findTransactionsByGroup(int group);

    boolean updateTransactionValidByCustomerId(long customer_id,int valid);

    List<MerchantAmt> findAmtByMerchant();

}
