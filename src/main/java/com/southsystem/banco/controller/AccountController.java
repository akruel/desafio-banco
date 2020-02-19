package com.southsystem.banco.controller;

import com.southsystem.banco.persistence.model.Account;
import com.southsystem.banco.persistence.model.BusinessAccount;
import com.southsystem.banco.persistence.model.CurrentAccount;
import com.southsystem.banco.persistence.service.AccountBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bank/v1")
public class AccountController {
    @Autowired
    private AccountBaseService<Account> accountService;

    @Autowired
    private AccountBaseService<CurrentAccount> currentAccountService;

    @Autowired
    private AccountBaseService<BusinessAccount> businessAccountService;

    @GetMapping("accounts")
    public ResponseEntity<Object> getAccounts() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("currentAccounts")
    public ResponseEntity<Object> getCurrentAccounts() {
        return new ResponseEntity<>(currentAccountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("businessAccounts")
    public ResponseEntity<Object> getBusinessAccounts() {
        return new ResponseEntity<>(businessAccountService.findAll(), HttpStatus.OK);
    }
}