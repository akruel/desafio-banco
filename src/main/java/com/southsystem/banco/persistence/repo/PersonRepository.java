package com.southsystem.banco.persistence.repo;

import com.southsystem.banco.persistence.model.Person;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends PersonBaseRepository<Person> {
}