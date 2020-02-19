package com.southsystem.banco.persistence.service;

import com.southsystem.banco.persistence.model.BusinessAccount;
import com.southsystem.banco.persistence.model.CurrentAccount;
import com.southsystem.banco.persistence.model.Person;
import com.southsystem.banco.persistence.repo.AccountBaseRepository;
import com.southsystem.banco.persistence.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonBaseService<Person> {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AccountBaseRepository<CurrentAccount> currentAccountRepository;

    @Autowired
    private AccountBaseRepository<BusinessAccount> businessAccountRepository;

    @Override
    public Person save(Person person) {
        person.setScore(person.generatePersonScore());
        Person personSaved = personRepository.save(person);
        if (person.getType() == "PF") {
            CurrentAccount currentAccount = new CurrentAccount();
            currentAccount.setAgency("0001");
            currentAccount.generateCreditCardLimit(personSaved.getScore());
            currentAccount.generateOverdraftLimit(personSaved.getScore());
            currentAccount.generateAccount(currentAccountRepository.save(currentAccount).getId());
            personSaved.setAccount(currentAccountRepository.save(currentAccount));
        }

        if (person.getType() == "PJ") {
            BusinessAccount businessAccount = new BusinessAccount();
            businessAccount.setAgency("0001");
            businessAccount.generateOverdraftLimit(personSaved.getScore());
            businessAccount.generateCreditCardLimit(personSaved.getScore());
            businessAccount.generateAccount(businessAccountRepository.save(businessAccount).getId());
            personSaved.setAccount(businessAccountRepository.save(businessAccount));
        }

        return personRepository.save(personSaved);
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}