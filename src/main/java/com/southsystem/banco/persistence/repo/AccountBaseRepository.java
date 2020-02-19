package com.southsystem.banco.persistence.repo;

import com.southsystem.banco.persistence.model.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBaseRepository<T extends Account> extends CrudRepository<T, Long> {
}