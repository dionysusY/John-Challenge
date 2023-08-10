package com.boot.challenge.controller;

import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import com.boot.challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ccc
 * @date 2023/8/10 - 0:08
 */

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/city/{city}")
    public List<Transactions> getTransMapByCity(@PathVariable String city) {
        return transactionService.getTransactionByCity(city);
    }

    @GetMapping("/state/{state}")
    public List<Transactions> getTransMapByState(@PathVariable String state) {
        return transactionService.getTransMapByState(state);
    }

    @GetMapping("/gender/{gender}")
    public List<Transactions> getTransactionsByGender(@PathVariable String gender) {
        //return transactionService.getTransactionsByGender(gender).subList(0,10);
        return transactionService.getTransactionsByGender(gender);
    }
    @GetMapping("/merchant/{merchant}")
    public List<Transactions> getTransactionsByMerchant(@PathVariable String merchant){
        System.out.println(merchant);
        return transactionService.getTsansactionsByMerchant(merchant);
    }

}
