package com.boot.challenge.controller;

import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import com.boot.challenge.service.CustomerService;
import com.boot.challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ccc
 * @date 2023/8/10 - 0:06
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/gender/{gender}")
    public List<Customer> getCustomerByGender(@PathVariable String gender,@RequestParam(required = false,defaultValue = "0") int pageno,
                                              @RequestParam(required = false,defaultValue = "10") int size) {
        return customerService.getCustomerGenderByPagination(gender,pageno,size).getCustomers();
    }
}
