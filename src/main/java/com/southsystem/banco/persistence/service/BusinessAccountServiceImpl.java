package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.BusinessAccount;
import com.southsystem.banco.persistence.repo.AccountBaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessAccountServiceImpl implements AccountBaseService<BusinessAccount> {

    @Autowired
    private AccountBaseRepository<BusinessAccount> businessAccountRepository; 

	@Override
	public BusinessAccount save(BusinessAccount businessAccount) {
		return businessAccountRepository.save(businessAccount);
	}

	@Override
	public Iterable<BusinessAccount> findAll() {
		return businessAccountRepository.findAll();
	}

}