package com.southsystem.banco.persistence.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import com.southsystem.banco.persistence.model.LegalPerson;

@Transactional
public interface LegalPersonRepository extends PersonBaseRepository<LegalPerson> {
    Optional<LegalPerson> findByCnpj(String cnpj);
}