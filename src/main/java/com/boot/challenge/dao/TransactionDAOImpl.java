package com.boot.challenge.dao;

import com.boot.challenge.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ccc
 * @date 2023/8/9 - 23:35
 */
@Repository
public class TransactionDAOImpl implements TransactionDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Transactions> findTransactionsByCity(String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("city").is(city));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByState(String state) {
        Query query = new Query();
        query.addCriteria(Criteria.where("state").is(state));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByGender(String gender) {
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is(gender));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByMerchant(String merchant) {
        Query query = new Query();
        query.addCriteria(Criteria.where("merchant").is(merchant));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByAmount(int sort) {
        Query query = new Query();
//        query.addCriteria(Criteria.where("amount"));
        Sort orders = sort==1?Sort.by(Sort.Direction.DESC,"amt"):Sort.by(Sort.Direction.ASC,"amt");
        PageRequest page = PageRequest.of(0,10);
        query.with(orders);
        query.with(page);
        List<Transactions> list = mongoTemplate.find(query, Transactions.class);
        return list;
    }


    @Override
    public List<Transactions> findTransactionsByCategory(String category){
        Query query = new Query();
        query.addCriteria(Criteria.where("category").regex(category));//模糊查询
        return mongoTemplate.find(query, Transactions.class);
    }
}
