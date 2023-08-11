package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.dto.PageData;
import com.boot.challenge.dto.PageResponse;
import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ccc
 * @date 2023/8/10 - 0:00
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;

    public List<Transactions> getTransactionByCity(String city){
        return transactionDAO.findTransactionsByCity(city);
    }

    public List<Transactions> getTransactionByState(String state) {
        return transactionDAO.findTransactionsByState(state);
    }

    public List<Transactions> getTransactionsByGender(String gender) {
        return transactionDAO.findTransactionsByGender(gender);
    }

    public List<Transactions> getTsansactionsByMerchant(String merchant){
        return transactionDAO.findTransactionsByMerchant(merchant);
    }
    public PageResponse getTransactionsGenderByPagination(String gender, int pageno, int size) {
        List<Transactions> transactionsList = getTransactionsByGender(gender);
        Pageable pageable = PageRequest.of(pageno, size);
        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = Math.min(start + pageable.getPageSize(),transactionsList.size());
        Page<Transactions> page = new PageImpl<>(transactionsList.subList(start,end));
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int noofelements = page.getNumberOfElements();
        int pagesize = page.getSize();
        PageResponse response = new PageResponse();
        response.setTransactions(page.getContent());
        response.setNoofelements(noofelements);
        response.setPagesize(pagesize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        return response;
    }

    public List<Transactions> getTransactionsByAmount(int sort,int pageNo,int size){
        return transactionDAO.findTransactionsByAmount(sort,pageNo,size);
    }

    public PageData<Transactions> getTransactionsByGroup(int group, int pageNum, int size) {
        List<Transactions> transactionsList = transactionDAO.findTransactionsByGroup(group);
        PageData<Transactions> result = new PageData<>();
        if (pageNum <= 0){
            pageNum = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        result.setCurrent(pageNum);
        result.setSize(size);
        result.setTotal(transactionsList.size());

        pageNum -= 1;
        Pageable pageable = PageRequest.of(pageNum, size);
        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = Math.min(start + pageable.getPageSize(), transactionsList.size());
        if (start > end){
            result.setRecords(null);
        }
        else {
            Page<Transactions> page = new PageImpl<>(transactionsList.subList(start, end));
            result.setRecords(page.getContent());
        }
        return result;
    }

    public List<Transactions> getTransactionByCategory(String category) {
        List<Transactions> transactions = transactionDAO.findTransactionsByCategory(category);
        return transactions;
    }

    public PageData<Transactions> getTransactionByCategoryPagination(String category, int pageNo, int size) {
        List<Transactions> transactionsList = getTransactionByCategory(category);
        PageData<Transactions> result = new PageData<>();
        if (pageNo<0){
            pageNo = 0;
        }
        if (size <= 0) {
            size = 10;
        }
        result.setCurrent(pageNo);
        result.setSize(size);
        result.setTotal(transactionsList.size());

        Pageable pageable = PageRequest.of(pageNo, size);
        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = Math.min(start + pageable.getPageSize(),transactionsList.size());
        if (end>=transactionsList.size()){
            result.setRecords(null);
        }
        else {
            Page<Transactions> page = new PageImpl<>(transactionsList.subList(start, end));
            result.setRecords(page.getContent());
        }
        return result;
    }
}
