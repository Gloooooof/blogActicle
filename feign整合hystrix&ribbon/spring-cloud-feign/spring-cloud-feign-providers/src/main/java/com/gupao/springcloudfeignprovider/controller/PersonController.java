package com.gupao.springcloudfeignprovider.controller;

import org.springframework.web.bind.annotation.*;
import pojo.Person;

@RestController
public class PersonController {

    @RequestMapping(value = "/demo/getHost", method = RequestMethod.GET)
    String getHost(){
        return "ok";
    }

    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    Person postPerson(String name){
        Person person = new Person();
        person.setId(1);
        person.setName(name);
        return person;
    }
}
