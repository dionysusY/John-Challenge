package com.boot.challenge.controller;

import com.boot.challenge.annotation.LogAnnotation;
import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.dto.CityAmt;
import com.boot.challenge.dto.GenderAmt;
import com.boot.challenge.dto.MerchantAmt;
import com.boot.challenge.dto.CategoryAmt;
import com.boot.challenge.dto.StateAmt;
import com.boot.challenge.dto.*;
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

    @LogAnnotation(module = "Statistics", operator = "getAmtByMerchant")
    @GetMapping("/amtbymerchant")
    public List<MerchantAmt> getAmtByMerchant(){
        return transactionService.getAmtByMerchant();
    }

    @LogAnnotation(module = "Statistics", operator = "getAmtByState")
    @GetMapping("/amtbystate")
    public List<StateAmt> getAmtByState() {
        return transactionService.getAmtByState();
    }

    @LogAnnotation(module = "Statistics", operator = "getAmtByCity")
    @GetMapping("/amtbycity")
    public List<CityAmt> getAmtByCity(){
        return transactionService.getAmtByCity();
    }


    @LogAnnotation(module = "Statistics", operator = "getAmtByGender")
    @GetMapping("/amtbygender")
    public List<GenderAmt> getAmtByGender(){
        return transactionService.getAmtByGender();
    }

    @LogAnnotation(module = "Statistics", operator = "getAmtByPopulation")
    @GetMapping("/amtbypopulation")
    public List<PopulationAmt> getAmtByPopulation(){
        return transactionService.getAmtByPopulation();
    }
    @LogAnnotation(module = "Statistics", operator = "getAmtByCategory")
    @GetMapping("/amtByCategory")
    public List<CategoryAmt> getAmtByCategory(){
        return transactionService.getAmtByCategory();
    }
}
