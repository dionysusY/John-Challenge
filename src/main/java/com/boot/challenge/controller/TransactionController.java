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
    TransactionService transactionService;

    @GetMapping("/{city}")
    public Map<Customer, List<Transactions>> getCustomer2TransMapByCity(@PathVariable String city) {
        return transactionService.getCustomer2TransMapByCity(city);
    }

    @GetMapping("/{state}")
    public Map<Customer, List<Transactions>> getCustomer2TransMapByState(@PathVariable String state) {
        return transactionService.getCustomer2TransMapByState(state);
    }

}