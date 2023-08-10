package com.boot.challenge.controller;

import com.boot.challenge.dto.PageData;
import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import com.boot.challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Transactions> getTransactionByCity(@PathVariable String city) {
        return transactionService.getTransactionByCity(city);
    }

    @GetMapping("/state/{state}")
    public List<Transactions> getTransactionByState(@PathVariable String state) {
        return transactionService.getTransactionByState(state);
    }

    @GetMapping("gender/{gender}")
    public List<Transactions> getTransactionsByGender(@PathVariable String gender,@RequestParam int pageno,
                                                      @RequestParam int size) {
        return transactionService.getTransactionsGenderByPagination(gender,pageno,size).getTransactions();
    }
    @GetMapping("category/{category}")
    public PageData<Transactions> getTransactionByCategory(@PathVariable String category, @RequestParam(defaultValue = "1") int pageNo,
                                                           @RequestParam(defaultValue = "10") int size) {
        return transactionService.getTransactionByCategoryPagination(category,pageNo,size);
    }
    @GetMapping("/merchant/{merchant}")
    public List<Transactions> getTransactionsByMerchant(@PathVariable String merchant){
        System.out.println(merchant);
        return transactionService.getTsansactionsByMerchant(merchant);
    }
    @GetMapping("/amount")
    public List<Transactions> getTransactionsByMerchant(@RequestParam(defaultValue = "1")int sort){
        return transactionService.getTransactionsByAmount(sort);
    }

    @GetMapping("/population_groups/{population}")
    public List<Transactions> getTransactionsByGroup(@RequestParam(defaultValue = "0") int group){
        return transactionService.getTransactionsByGroup(group);
    }
}
