package com.boot.challenge.controller;

import com.boot.challenge.dto.PageData;
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
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public PageData<Customer> getAllCustomer(@RequestParam(required = false, defaultValue = "0") int pageno,
                                             @RequestParam(required = false, defaultValue = "10")int size){
        return customerService.getCustomerPagination(pageno, size);
    }

    @GetMapping("/gender/{gender}")
    public List<Customer> getCustomerByGender(@PathVariable String gender,@RequestParam(required = false,defaultValue = "0") int pageno,
                                              @RequestParam(required = false,defaultValue = "10") int size) {
        return customerService.getCustomerGenderByPagination(gender,pageno,size).getCustomers();
    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestParam("first") String first,
                                @RequestParam("last") String last,
                                @RequestParam("gender") String gender,
                                @RequestParam("job") String job){
        Customer addCustomer = customerService.addCustomer(first, last, gender, job);
        return addCustomer;
    }

    @DeleteMapping("/deletecustomer")
    public boolean deleteCustomer(@RequestParam("first") String first,
                                  @RequestParam("last") String last){
        boolean flag = customerService.deleteCustomer(first,last);
        return flag;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.findCustomerById(id);
    }
}
