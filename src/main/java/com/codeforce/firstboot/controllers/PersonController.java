package com.codeforce.firstboot.controllers;

import com.codeforce.firstboot.PersonMapper;
import com.codeforce.firstboot.repositories.AccountEntity;
import com.codeforce.firstboot.repositories.PersonEntity;
import com.codeforce.firstboot.resources.AccountResource;
import com.codeforce.firstboot.resources.PersonModel;
import com.codeforce.firstboot.resources.PersonResource;
import com.codeforce.firstboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController("Person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*
        @GetMapping("/GetPersonByName")
        @ResponseStatus(HttpStatus.OK)
        public PersonResource getPersonbyName(String name){
            return personService.getPersonByName(name);
        }

        @GetMapping("/GetAll")
        @ResponseStatus(HttpStatus.OK)
        public List<PersonEntity> getAllPersons(){
            List<PersonEntity> list = StreamSupport.stream(personService.getAll().spliterator(), false)
                    .collect(Collectors.toList());
            return list;
        }
     */
    @PostMapping("/CreatePersonWithModel")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResource addPerson(@RequestBody @Valid PersonModel model) {
        PersonEntity entity = PersonMapper.getEntity(model);
        return personService.create(entity);
    }

    @GetMapping("/Login")
    @ResponseStatus(HttpStatus.OK)
    public String login(Long cardNumber, long pin) {
        return personService.login(cardNumber, pin);
    }


    @GetMapping("/Login/CheckBalance")
    @ResponseStatus(HttpStatus.OK)
    public String checkBallance(Long cardNumber, Long pin) {
        return personService.checkBalance(cardNumber, pin);
    }

    @PutMapping("Login/deposit")
    @ResponseStatus(HttpStatus.OK)
    public String deposit(@RequestParam Long cardNumber, @RequestParam Long pin, @RequestParam Long depositAmount) {
        return personService.deposit(cardNumber, pin, depositAmount);
    }

    @PutMapping("Login/withdrawal")
    @ResponseStatus(HttpStatus.OK)
    public String withdrawal(@RequestParam Long cardNumber, @RequestParam Long pin, @RequestParam Long withdrawalAmount) {
        return personService.withdrawal(cardNumber, pin, withdrawalAmount);
    }
}