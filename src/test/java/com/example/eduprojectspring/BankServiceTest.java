package com.example.eduprojectspring;

import com.example.eduprojectspring.repository.BalanceRepository;
import com.example.eduprojectspring.service.BankService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankServiceTest {
    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);

    @Test
    void getBalance(){
        final BigDecimal balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }

    @Test
    void addMoney(){
        final BigDecimal balance = bankService.addMoney(5L, BigDecimal.TEN);
        assertEquals(balance, BigDecimal.valueOf(10));
    }
}
