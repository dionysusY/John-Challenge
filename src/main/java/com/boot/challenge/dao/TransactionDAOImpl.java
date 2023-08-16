package com.boot.challenge.dao;

import com.boot.challenge.dto.CategoryAmt;
import com.boot.challenge.dto.MerchantAmt;
import com.boot.challenge.entity.Transactions;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

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
        query.addCriteria(Criteria.where("city").is(city).and("valid").is(1));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByState(String state) {
        Query query = new Query();
        query.addCriteria(Criteria.where("state").is(state).and("valid").is(1));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByGender(String gender) {
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is(gender).and("valid").is(1));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByMerchant(String merchant) {
        Query query = new Query();
        query.addCriteria(Criteria.where("merchant").is(merchant).and("valid").is(1));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByAmount(int sort,int pageNo,int size) {
        Query query = new Query();
        query.addCriteria(Criteria.where("valid").is(1));
        Sort orders = sort==1?Sort.by(Sort.Direction.DESC,"amt"):Sort.by(Sort.Direction.ASC,"amt");
        PageRequest page = PageRequest.of(pageNo,size);
        query.with(orders);
        query.with(page);
        List<Transactions> list = mongoTemplate.find(query, Transactions.class);
        return list;
    }


    @Override
    public List<Transactions> findTransactionsByCategory(String category){
        Query query = new Query();
        query.addCriteria(Criteria.where("category").regex(category).and("valid").is(1));//模糊查询
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public List<Transactions> findTransactionsByGroup(int group) {
        Query query = new Query();
        query.addCriteria(Criteria.where("city_population").is(group).and("valid").is(1));
        return mongoTemplate.find(query, Transactions.class);
    }

    @Override
    public boolean updateTransactionValidByCustomerId(long customer_id, int valid) {
        Query query = new Query(Criteria.where("customer_id").is(customer_id));
        Update update = new Update();
        update.set("valid",valid);
        UpdateResult updateResult = mongoTemplate.updateMulti(query,update,Transactions.class);
        System.out.println(updateResult);
        return true;
    }

    public List<MerchantAmt> findAmtByMerchant(){
        MatchOperation allMerchants = match(new Criteria("merchant").exists(true));
        GroupOperation groupByCountrySumSales = group("merchant").sum("amt").as("total_amt");
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"total_amt"));
        ProjectionOperation includes = project("total_amt").and("merchant").previousOperation();
        Aggregation aggregation = newAggregation(allMerchants, groupByCountrySumSales,sortBySalesDesc, limit(20), includes);
        AggregationResults<MerchantAmt> groupResults = mongoTemplate.aggregate(aggregation, "transactions", MerchantAmt.class);
        List<MerchantAmt> result = groupResults.getMappedResults();
        return result;
    }


    public List<CategoryAmt> findAmtByCategory(){


        MatchOperation allCategory = match(new Criteria("category").exists(true));
        GroupOperation groupByCategorySumSales = group("category").sum("amt").as("total_amt");
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"total_amt"));
        ProjectionOperation includes = project("total_amt").and("category").previousOperation();
        Aggregation aggregation = newAggregation(allCategory, groupByCategorySumSales,sortBySalesDesc, includes);
        AggregationResults<CategoryAmt> groupResults = mongoTemplate.aggregate(aggregation, "transactions", CategoryAmt.class);
        List<CategoryAmt> result = groupResults.getMappedResults();
        return result;
    }


}
