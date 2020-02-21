package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.PhysicalPerson;
import com.southsystem.banco.persistence.repo.PersonBaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PhysicalPersonServiceImpl implements PersonBaseService<PhysicalPerson> {
    @Autowired
    private PersonBaseRepository<PhysicalPerson> physicalPersonRepository;

    @Override
    public PhysicalPerson save(PhysicalPerson physicalPerson) {
        return physicalPersonRepository.save(physicalPerson);
    }

    @Override
    public Iterable<PhysicalPerson> findAll(Specification<PhysicalPerson> spec) {
        return physicalPersonRepository.findAll(spec);
    }
}