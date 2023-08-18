package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.DatabaseSequenceRepository;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.dto.PageData;
import com.boot.challenge.dto.PageResponse;
import com.boot.challenge.entity.Customer;
import com.boot.challenge.entity.Transactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * @ccc
 * @date 2023/8/9 - 23:52
 */
@Service
public class CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
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

    public Customer addCustomer(String first, String last, String gender, String job, String date) throws java.text.ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date dob = dateFormat.parse(date);
        Customer newCustomer = new Customer(first, last, gender, job, dob, 1);
        newCustomer.setCustomerID(databaseSequenceRepository.generateSequence(Customer.generateSequenceName));
        Customer addCustomer = customerDAO.addCustomer(newCustomer);
        return addCustomer;
    }

    public PageResponse getCustomerGenderByPagination(String gender, int pageno, int size) {
        if(pageno < 0){
            pageno = 0;
        }
        if(size <= 0){
            size = 10;
        }
        List<Customer> customerList = getCustomerByGender(gender);
        Pageable pageable = PageRequest.of(pageno, size);
        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = Math.min(start + pageable.getPageSize(),customerList.size());
        Page<Customer> page = new PageImpl<>(customerList.subList(start,end));
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int noofelements = page.getNumberOfElements();
        int pagesize = page.getSize();
        PageResponse response = new PageResponse();
        response.setCustomers(page.getContent());
        response.setNoofelements(noofelements);
        response.setPagesize(pagesize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        return response;
    }

    public boolean deleteCustomer(String first,String last){
        Customer customer = customerDAO.findCustomersByName(first,last);
        try{
            boolean result1 = customerDAO.updateCustomerValidById(customer.getCustomerID(),0);
            boolean result2 = false;
            if(result1) result2 = transactionDAO.updateTransactionValidByCustomerId(customer.getCustomerID(),0);
            return result2;
        }catch (Exception e){
            logger.info("delete a customer failed, error={}", e.toString());
            return false;
        }
    }

    public PageData<Customer> getCustomerPagination(int pageNum, int size){
        List<Customer> CustomerList = customerDAO.findAllCustomer();
        PageData<Customer> result = new PageData<Customer>();
        if (pageNum <= 0){
            pageNum = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        result.setCurrent(pageNum);
        result.setSize(size);
        result.setTotal(CustomerList.size());

        pageNum -= 1;
        Pageable pageable = PageRequest.of(pageNum, size);
        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = Math.min(start + pageable.getPageSize(), CustomerList.size());
        if (start > end){
            result.setRecords(null);
        }
        else {
            Page<Customer> page = new PageImpl<>(CustomerList.subList(start, end));
            result.setRecords(page.getContent());
        }
        return result;
    }

}
