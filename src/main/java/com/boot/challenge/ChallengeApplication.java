package com.boot.challenge;

import com.boot.challenge.dao.TransactionDAOImpl;
import com.boot.challenge.entity.Transactions;
import com.boot.challenge.service.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext contxt = SpringApplication.run(ChallengeApplication.class, args);
//        TransactionService t = contxt.getBean(TransactionService.class);
//        List<Transactions> res = t.getTransactionsByGender("F");
//        for(Transactions tt:res){
//            System.out.println(tt.toString());
//        }

    }

}
