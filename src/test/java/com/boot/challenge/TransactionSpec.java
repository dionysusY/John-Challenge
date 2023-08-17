package com.boot.challenge;

import com.boot.challenge.dao.TransactionDAO;
import com.boot.challenge.entity.Transactions;
import com.boot.challenge.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionSpec {
    @Mock
    TransactionDAO transactionDAO;
    @InjectMocks
    TransactionService service;

    List<Transactions> collection;
    Transactions trans1,trans2,trans3;

    @BeforeEach
    public void befEach(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp(){
        trans1 = new Transactions("23/02/2020 21:38", 40.11, 324, "Achille", "OK",
               74720, "Abbott-Rogahn", "entertainment", "Felicia", "Thomas",
                "F", "Seismic interpreter","27/05/1993",1);
        trans2 = new Transactions("25/02/2020 21:38", 40.11, 324, "Achille", "OK",
                74720, "Abbott-Rogahn", "entertainment", "Felicia", "Thomas",
                "M", "Seismic interpreter","27/05/1993",1);
        trans3 = new Transactions("23/02/2020 21:38", 40.11, 324, "Achille", "OK",
                74720, "Abbotb-Rogahn", "entertainment", "Felicia", "Thomas",
                "M", "Seismic interpreter","27/05/1993",1);
        collection = Arrays.asList(trans1,trans2,trans3);
    }
    @Test
    public void getTransByGenderSpec() {
        when(transactionDAO.findTransactionsByGender("M")).thenReturn(Arrays.asList(trans2,trans3));
        List<Transactions> returnValue = service.getTransactionsByGender("M");
        assertEquals(Arrays.asList(trans2,trans3),returnValue);

    }
}
