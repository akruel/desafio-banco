package com.southsystem.banco.persistence.repo;

import com.southsystem.banco.persistence.model.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository<T extends Person> extends CrudRepository<T, Long> {
}