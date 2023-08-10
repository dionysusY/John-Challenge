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

    @Autowired
    private CustomerDAO customerDAO;

    public Map<Customer, List<Transactions>> getCustomer2TransMapByCity(String city) {
        List<Transactions> transactions = transactionDAO.findTransactionsByCity(city);
//        Map<Long, List<Transactions>> customerId2TransactionsMap = new HashMap<>();
        return queryCustomerByIds(transactions);
    }

    public Map<Customer, List<Transactions>> getCustomer2TransMapByState(String state) {
        List<Transactions> transactions = transactionDAO.findTransactionsByState(state);
//        Map<Long, List<Transactions>> customerId2TransactionsMap = new HashMap<>();
//        return queryCustomerByIds(customerId2TransactionsMap, transactions);
        return queryCustomerByIds(transactions);
    }

    private Map<Customer, List<Transactions>> queryCustomerByIds(List<Transactions> transactions) {
        Map<Long, List<Transactions>> customerId2TransactionsMap = new HashMap<>();
        for (Transactions transaction : transactions) {
            Long customerId = transaction.getCustomId();
            List<Transactions> transactionsList = customerId2TransactionsMap.getOrDefault(customerId, new ArrayList<>());
            transactionsList.add(transaction);
            customerId2TransactionsMap.put(customerId, transactionsList);
        }

        Map<Customer, List<Transactions>> result = new HashMap<>();
        for (Map.Entry<Long, List<Transactions>> entry : customerId2TransactionsMap.entrySet()) {
            Customer customer = customerDAO.findCustomersById(entry.getKey());
            result.put(customer, entry.getValue());
        }

        return result;
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

    public List<Transactions> getTransactionsByAmount(int sort){
        return transactionDAO.findTransactionsByAmount(sort);
    }

    public List<Transactions> getTransactionsByGroup(int group){
        return transactionDAO.findTransactionsByGroup(group);
    }

    public List<Transactions> getTransactionByCategory(String category) {
        List<Transactions> transactions = transactionDAO.findTransactionsByCategory(category);
        return transactions;
    }

    public PageData<Transactions> getTransactionByCategoryPagination(String category, int pageNo, int size) {
        List<Transactions> transactionsList = getTransactionByCategory(category);
        PageData<Transactions> result = new PageData<>();
        if (pageNo<=0){
            pageNo = 1;
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
