package com.boot.challenge.controller;

import com.boot.challenge.annotation.LogAnnotation;
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
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @LogAnnotation(module = "Transaction", operator = "getTransactionByCity")
    @GetMapping("/city/{city}")
    public PageData<Transactions> getTransactionByCity(@PathVariable String city, @RequestParam(defaultValue = "0") int pageNo,
                                                   @RequestParam(defaultValue = "10") int size) {
        return transactionService.getTransactionByCityPagination(city,pageNo,size);
    }

    @LogAnnotation(module = "Transaction", operator = "getTransactionByState")
    @GetMapping("/state/{state}")
    public PageData<Transactions> getTransactionByState(@PathVariable String state, @RequestParam(defaultValue = "0") int pageNo,
                                                        @RequestParam(defaultValue = "10") int size) {
        return transactionService.getTransactionByStatePagination(state,pageNo,size);
    }


    @LogAnnotation(module = "Transaction", operator = "getTransactionsByGender")
    @GetMapping("gender/{gender}")
    public List<Transactions> getTransactionsByGender(@PathVariable String gender,@RequestParam(defaultValue = "0") int pageno,
                                                      @RequestParam(defaultValue = "10") int size) {
        return transactionService.getTransactionsGenderByPagination(gender,pageno,size).getTransactions();
    }
    @LogAnnotation(module = "Transaction", operator = "getTransactionByCategory")
    @GetMapping("category/{category}")
    public PageData<Transactions> getTransactionByCategory(@PathVariable String category, @RequestParam(defaultValue = "0") int pageNo,
                                                           @RequestParam(defaultValue = "10") int size) {
        return transactionService.getTransactionByCategoryPagination(category,pageNo,size);
    }
    @LogAnnotation(module = "Transaction", operator = "getTransactionsByMerchant")
    @GetMapping("/merchant/{merchant}")
    public PageData<Transactions> getTransactionsByMerchant(@PathVariable String merchant,
                                                        @RequestParam(defaultValue = "0")int pageNo,
                                                        @RequestParam(defaultValue = "10") int size){
        System.out.println(merchant);
        return transactionService.getTransactionsByMerchantPagination(merchant, pageNo, size);
    }
    @LogAnnotation(module = "Transaction", operator = "getTransactionsByAmount")
    @GetMapping("/amount")
    public List<Transactions> getTransactionsByAmount(@RequestParam(defaultValue = "1")int sort,@RequestParam(defaultValue = "0")int pageNo,
                                                      @RequestParam(defaultValue = "10") int size){
        return transactionService.getTransactionsByAmount(sort,pageNo,size);
    }

    @LogAnnotation(module = "Transaction", operator = "getTransactionsByGroup")
    @GetMapping("/population_groups/{group}")
    public PageData<Transactions> getTransactionsByGroup(@PathVariable int group, @RequestParam(defaultValue = "1") int pageNo,
                                                     @RequestParam(defaultValue = "10") int size){
        return transactionService.getTransactionsByGroup(group, pageNo, size);
    }

    @LogAnnotation(module = "Transaction", operator = "getTransactionByCustomerId")
    @GetMapping("/customerid/{id}")
    public PageData<Transactions> getTransactionByCustomerId(@PathVariable long id,
                                                             @RequestParam(defaultValue = "1") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize){
        return transactionService.getTransactionsByCustomerIdPagination(id, pageNo, pageSize);
    }
}
