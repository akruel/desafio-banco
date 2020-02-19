package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.Account;
import com.southsystem.banco.persistence.repo.AccountBaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountBaseService<Account> {

    @Autowired
    private AccountBaseRepository<Account> accountRepository; 

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

}