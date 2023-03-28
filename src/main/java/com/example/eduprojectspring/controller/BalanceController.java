package com.example.eduprojectspring.controller;

import com.example.eduprojectspring.model.TransferBalance;
import com.example.eduprojectspring.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanceController {
    private final BankService bankService;


    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){
        bankService.makeTransfer(transferBalance);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String handle(IllegalAccessException e){
        log.error(e.getMessage());
        return "MAMA YA SLOMALSYA";
    }
}
