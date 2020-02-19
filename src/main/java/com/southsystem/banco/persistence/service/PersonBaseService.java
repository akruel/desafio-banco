package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.Person;

public interface PersonBaseService<T extends Person> {
    T save(T person);
    Iterable<T> findAll();
}