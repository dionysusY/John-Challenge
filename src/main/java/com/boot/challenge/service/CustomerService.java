package com.boot.challenge.service;

import com.boot.challenge.dao.CustomerDAO;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.dto.PageResponse;
import com.boot.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Customer findCustomerById(long _id) {
        return this.customerDAO.findCustomersById(_id);
    }
    public List<Customer> getCustomerByGender(String gender) {
        return customerDAO.findCustomersByGender(gender);
    }

    public PageResponse getCustomerGenderByPagination(String gender, int pageno, int size) {
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

}
