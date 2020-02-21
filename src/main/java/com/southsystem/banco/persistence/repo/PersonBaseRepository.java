package com.southsystem.banco.persistence.repo;

import java.util.Optional;

import com.southsystem.banco.persistence.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository<T extends Person> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    Optional<Person> findByName(String name);
    Optional<Person> findByScore(int score);
}