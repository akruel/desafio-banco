package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.Account;

public interface AccountBaseService<T extends Account> {
    T save(T account);
    Iterable<T> findAll();
}