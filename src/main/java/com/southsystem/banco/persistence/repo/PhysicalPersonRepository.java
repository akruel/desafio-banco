package com.southsystem.banco.persistence.repo;

import javax.transaction.Transactional;

import com.southsystem.banco.persistence.model.PhysicalPerson;

@Transactional
public interface PhysicalPersonRepository extends PersonBaseRepository<PhysicalPerson> {
}