package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.LegalPerson;
import com.southsystem.banco.persistence.repo.LegalPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LegalPersonServiceImpl implements PersonBaseService<LegalPerson> {
    @Autowired
    private LegalPersonRepository legalPersonRepository;

    @Override
    public LegalPerson save(LegalPerson legalPerson) {
        return legalPersonRepository.save(legalPerson);
    }

    @Override
    public Iterable<LegalPerson> findAll() {
        return legalPersonRepository.findAll();
    }
}