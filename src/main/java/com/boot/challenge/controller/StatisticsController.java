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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/amtbymerchant")
    public List<MerchantAmt> getAmtByMerchant(){
        return transactionService.getAmtByMerchant();
    }

    @GetMapping("/amtbystate")
    public List<StateAmt> getAmtByState() {
        return transactionService.getAmtByState();
    }

    @GetMapping("/amtbycity")
    public List<CityAmt> getAmtByCity(){
        return transactionService.getAmtByCity();
    }


    @GetMapping("/amtbygender")
    public List<GenderAmt> getAmtByGender(){
        return transactionService.getAmtByGender();
    }

    @GetMapping("/amtbypopulation")
    public List<PopulationAmt> getAmtByPopulation(){
        return transactionService.getAmtByPopulation();
    }

    @GetMapping("/amtByCategory")
    public List<CategoryAmt> getAmtByCategory(){
        return transactionService.getAmtByCategory();
    }
}
