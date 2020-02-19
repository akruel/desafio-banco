package com.southsystem.banco.persistence.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import com.southsystem.banco.persistence.model.PhysicalPerson;

@Transactional
public interface PhysicalPersonRepository extends PersonBaseRepository<PhysicalPerson> {
    Optional<PhysicalPerson> findByCpf(String cpf);
}