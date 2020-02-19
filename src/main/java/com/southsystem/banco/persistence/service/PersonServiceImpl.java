package com.southsystem.banco.persistence.service;

import com.southsystem.banco.exceptions.PersonDuplicatedException;
import com.southsystem.banco.persistence.model.BusinessAccount;
import com.southsystem.banco.persistence.model.CurrentAccount;
import com.southsystem.banco.persistence.model.LegalPerson;
import com.southsystem.banco.persistence.model.Person;
import com.southsystem.banco.persistence.model.PhysicalPerson;
import com.southsystem.banco.persistence.repo.AccountBaseRepository;
import com.southsystem.banco.persistence.repo.LegalPersonRepository;
import com.southsystem.banco.persistence.repo.PersonRepository;
import com.southsystem.banco.persistence.repo.PhysicalPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonBaseService<Person> {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PhysicalPersonRepository physicalPersonRepository;

    @Autowired
    private LegalPersonRepository legalPersonRepository;

    @Autowired
    private AccountBaseRepository<CurrentAccount> currentAccountRepository;

    @Autowired
    private AccountBaseRepository<BusinessAccount> businessAccountRepository;

    // private Person personToTrySave;

    @Override
    public Person save(Person person) throws PersonDuplicatedException {
        if (person.getType() == "PF") {
            PhysicalPerson physicalPerson = (PhysicalPerson) person;
            if(physicalPersonRepository.findByCpf(physicalPerson.getCpf()).isPresent()){
                throw new PersonDuplicatedException("CPF já cadastrado");
            }
            person.setScore(person.generatePersonScore());
            person = personRepository.save(person);
            CurrentAccount currentAccount = new CurrentAccount();
            currentAccount.setAgency("0001");
            currentAccount.generateCreditCardLimit(person.getScore());
            currentAccount.generateOverdraftLimit(person.getScore());
            currentAccount.generateAccount(currentAccountRepository.save(currentAccount).getId());
            person.setAccount(currentAccountRepository.save(currentAccount));
        }

        if (person.getType() == "PJ") {
            LegalPerson legalPerson = (LegalPerson) person;
            if(legalPersonRepository.findByCnpj(legalPerson.getCnpj()).isPresent()){
                throw new PersonDuplicatedException("CNPJ já cadastrado");
            }
            person.setScore(person.generatePersonScore());
            person = personRepository.save(person);
            BusinessAccount businessAccount = new BusinessAccount();
            businessAccount.setAgency("0001");
            businessAccount.generateOverdraftLimit(person.getScore());
            businessAccount.generateCreditCardLimit(person.getScore());
            businessAccount.generateAccount(businessAccountRepository.save(businessAccount).getId());
            person.setAccount(businessAccountRepository.save(businessAccount));
        }

        return personRepository.save(person);
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}