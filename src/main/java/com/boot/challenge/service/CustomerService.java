package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.DatabaseSequenceRepository;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    private DatabaseSequenceRepository databaseSequenceRepository;

    public Customer findCustomerById(long _id) {
        return this.customerDAO.findCustomersById(_id);
    }
    public List<Customer> getCustomerByGender(String gender) {
        return customerDAO.findCustomersByGender(gender);
    }

    public Customer addCustomer(String first, String last, String gender, String job){
        Customer newCustomer = new Customer(first, last, gender, job, new Date());
        newCustomer.setCustomerID(databaseSequenceRepository.generateSequence(Customer.generateSequenceName));
        Customer addCustomer = customerDAO.addCustomer(newCustomer);
        return addCustomer;
    }

}
