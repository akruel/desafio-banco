// package com.southsystem.banco.controller;

// import javax.validation.Valid;

// import com.southsystem.banco.exceptions.InvalidPersonTypeException;
// import com.southsystem.banco.exceptions.MinimalDocException;
// import com.southsystem.banco.persistence.model.Account;
// import com.southsystem.banco.persistence.model.Person;
// import com.southsystem.banco.persistence.repo.AccountRepository;
// import com.southsystem.banco.persistence.repo.PersonRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin
// @RestController
// @RequestMapping("api/bank/v1")
// public class PersonController {
//     @Autowired
//     private PersonRepository personRepository;

//     @Autowired
//     private AccountRepository accountRepository;

//     @PostMapping("person")
//     public ResponseEntity<Object> savePerson(@Valid @RequestBody Person person) throws InvalidPersonTypeException {
//         if (person.getPersonType().equals("PF") || person.getPersonType().equals("PJ")) {
//             if(person.getPersonType().equals("PF")){
//                 if(person.getDocument().length() < 11 || person.getDocument().length() > 11) {
//                     throw new MinimalDocException("Document deve conter 11 caracteres!");
//                 }
//             }
//             if(person.getPersonType().equals("PJ")){
//                 if(person.getDocument().length() < 14 || person.getDocument().length() > 14) {
//                     throw new MinimalDocException("Document deve conter 14 caracteres!");
//                 }
//             }
//             Account account = new Account();
//             person.setScore(person.generatePersonScore());
//             personRepository.save(person);
//             if (person.getPersonType().equals("PF")) {
//                 account.setAccountType("CURRENT");
//                 account.setPerson(person);
//             }
//             if (person.getPersonType().equals("PJ")) {
//                 account.setAccountType("BUSINESS");
//                 account.setPerson(person);
//             }
//             account.setAgency("0001");
//             account.generateOverdraftLimit(person.getScore());
//             account.generateAccount(accountRepository.save(account).getId());

//             accountRepository.save(account);
//             return new ResponseEntity<>(HttpStatus.CREATED);
//         } else {
//             throw new InvalidPersonTypeException("PersonType deve ser PF ou PJ!");
//         }

//     }

//     @GetMapping("persons")
//     public ResponseEntity<Object> getPersons() {
//         return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
//     }

//     @GetMapping("accounts")
//     public ResponseEntity<Object> getAccounts() {
//         return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
//     }
// }