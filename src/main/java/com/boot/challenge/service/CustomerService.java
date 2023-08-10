package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ccc
 * @date 2023/8/9 - 23:52
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    public Customer findCustomerById(long _id) {
        return this.customerDAO.findCustomersById(_id);
    }
    public List<Customer> getCustomerByGender(String gender) {
        return customerDAO.findCustomersByGender(gender);
    }

}
