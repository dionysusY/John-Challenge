package com.boot.challenge.dao;

import com.boot.challenge.entity.Customer;

import java.util.List;

/**
 * @ccc
 * @date 2023/8/9 - 23:25
 */
public interface CustomerDAO {
    public Customer findCustomersById(long customer_id);
    public List<Customer> findCustomersByGender(String gender);

    public Customer addCustomer(Customer newCustomer);

    public  Customer findCustomersByName(String first,String last);

    public boolean updateCustomerValidById(long customer_id,int valid);

    public List<Customer> findAllCustomer();
}
