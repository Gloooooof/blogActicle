package com.gupao.springcloudfeignconsumer.controller;

import com.gupao.springcloudfeignapi.api.PersonService;
import com.gupao.springcloudfeignapi.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController implements PersonService {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean save(Person person) {
        return personService.save(person);
    }
}
