// package com.southsystem.banco.controller;

// import java.util.Arrays;
// import java.util.List;

// import com.southsystem.banco.persistence.model.Person;
// import com.southsystem.banco.persistence.repo.AccountRepository;
// import com.southsystem.banco.persistence.repo.PersonRepository;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.mockito.BDDMockito.given;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



// @RunWith(SpringRunner.class)
// @WebMvcTest(value = PersonController.class)
// public class PersonControllerTest {

// 	@Autowired
//     private MockMvc mockMvc;
    
//     @MockBean
//     private PersonRepository personRepository;

//     @MockBean
//     private AccountRepository accountRepository;

//     @Test
//     public void findAll() throws Exception {
//         Person person = new Person();
//         person.setId(1L);
//         person.setName("Test");
//         person.setPersonType("PJ");
//         person.setDocument("86281690087");
//         person.setScore(7);
//         List<Person> persons = Arrays.asList(person);
//         given(personRepository.findAll()).willReturn(persons);

//         this.mockMvc.perform(get("/api/bank/v1/persons"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().json("[{'id': 1,'name': 'Test','personType': 'PJ','score': 7,'document': '86281690087'}]"));
//     }   

    
// }