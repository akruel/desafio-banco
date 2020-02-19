package com.southsystem.banco.controller;

import com.southsystem.banco.exceptions.PersonDuplicatedException;
import com.southsystem.banco.persistence.model.LegalPerson;
import com.southsystem.banco.persistence.model.Person;
import com.southsystem.banco.persistence.model.PhysicalPerson;
import com.southsystem.banco.persistence.service.PersonBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bank/v1")
public class PersonController {

    @Autowired
    private PersonBaseService<Person> personService;

    @Autowired
    private PersonBaseService<LegalPerson> legalPersonService;

    @Autowired
    private PersonBaseService<PhysicalPerson> physicalPersonService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Person person) throws PersonDuplicatedException {
        personService.save(person);
    }

    @GetMapping("persons")
    public ResponseEntity<Object> getPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("legalPersons")
    public ResponseEntity<Object> getLegalPersons() {
        return new ResponseEntity<>(legalPersonService.findAll(), HttpStatus.OK);
    }

    @GetMapping("physicalPersons")
    public ResponseEntity<Object> getPhysicalPersons() {
        return new ResponseEntity<>(physicalPersonService.findAll(), HttpStatus.OK);
    }
}