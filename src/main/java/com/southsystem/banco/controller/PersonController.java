package com.southsystem.banco.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.southsystem.banco.exceptions.PersonDuplicatedException;
import com.southsystem.banco.persistence.model.LegalPerson;
import com.southsystem.banco.persistence.model.Person;
import com.southsystem.banco.persistence.model.PhysicalPerson;
import com.southsystem.banco.persistence.service.PersonBaseService;
import com.southsystem.banco.persistence.specification.PersonSpecificationBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Object> getPersons(@RequestParam(value = "search") String search) {
        PersonSpecificationBuilder<Person> builder = new PersonSpecificationBuilder<Person>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Person> spec = builder.build();

        return new ResponseEntity<>(personService.findAll(spec), HttpStatus.OK);
    }

    @GetMapping("legalPersons")
    public ResponseEntity<Object> getLegalPersons(@RequestParam(value = "search") String search) {
        PersonSpecificationBuilder<LegalPerson> builder = new PersonSpecificationBuilder<LegalPerson>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<LegalPerson> spec = builder.build();

        return new ResponseEntity<>(legalPersonService.findAll(spec), HttpStatus.OK);
    }

    @GetMapping("physicalPersons")
    public ResponseEntity<Object> getPhysicalPersons(@RequestParam(value = "search") String search) {
        PersonSpecificationBuilder<PhysicalPerson> builder = new PersonSpecificationBuilder<PhysicalPerson>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<PhysicalPerson> spec = builder.build();

        return new ResponseEntity<>(physicalPersonService.findAll(spec), HttpStatus.OK);
    }
}