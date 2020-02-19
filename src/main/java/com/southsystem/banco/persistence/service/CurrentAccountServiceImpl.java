package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.CurrentAccount;
import com.southsystem.banco.persistence.repo.AccountBaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrentAccountServiceImpl implements AccountBaseService<CurrentAccount> {

    @Autowired
    private AccountBaseRepository<CurrentAccount> currentAccountRepository; 

	@Override
	public CurrentAccount save(CurrentAccount account) {
		return currentAccountRepository.save(account);
	}

	@Override
	public Iterable<CurrentAccount> findAll() {
		return currentAccountRepository.findAll();
	}

}