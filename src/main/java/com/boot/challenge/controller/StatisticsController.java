package com.boot.challenge.controller;

import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.dto.MerchantAmt;
import com.boot.challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/amtbymerchant")
    public List<MerchantAmt> getAmtByMerchant(){
        return transactionService.getAmtByMerchant();
    }

}
