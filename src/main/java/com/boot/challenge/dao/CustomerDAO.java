package com.boot.challenge.dao;

import com.boot.challenge.entity.Customer;

/**
 * @ccc
 * @date 2023/8/9 - 23:25
 */
public interface CustomerDAO {
    public Customer findCustomersById(long customer_id);
}
