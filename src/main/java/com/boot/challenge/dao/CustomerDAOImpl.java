package com.boot.challenge.dao;

import com.boot.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * @ccc
 * @date 2023/8/9 - 23:26
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Customer findCustomersById(long customer_id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customer_id));
        return mongoTemplate.findOne(query, Customer.class);
    }
}