package com.southsystem.banco.persistence.repo;

import com.southsystem.banco.persistence.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends JpaRepository<Account, String>, JpaSpecificationExecutor<Account> {
}