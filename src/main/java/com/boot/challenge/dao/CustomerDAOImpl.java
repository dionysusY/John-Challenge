package com.boot.challenge.dao;

import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


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
        query.addCriteria(Criteria.where("_id").is(customer_id).and("valid").is(1));
        return mongoTemplate.findOne(query, Customer.class);
    }

    @Override
    public List<Customer> findCustomersByGender(String gender) {
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is(gender).and("valid").is(1));
        return mongoTemplate.find(query, Customer.class);
    }

    @Override
    public Customer addCustomer(Customer newCustomer) {
       Customer addCustomer = mongoTemplate.save(newCustomer);
       return addCustomer;
    }

    @Override
    public Customer findCustomersByName(String first, String last) {
        Query query = new Query();
        query.addCriteria(Criteria.where("first").is(first).and("last").is(last));
        return mongoTemplate.findOne(query,Customer.class);
    }

    @Override
    public boolean updateCustomerValidById(long customer_id,int valid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customer_id).and("valid").is(1));

        Update update = new Update();
        update.set("valid",0);
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,Customer.class);
        System.out.println(updateResult);
        return true;
    }
}
