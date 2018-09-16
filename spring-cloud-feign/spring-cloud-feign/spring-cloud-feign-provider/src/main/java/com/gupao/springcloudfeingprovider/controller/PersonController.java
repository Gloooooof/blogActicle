package com.gupao.springcloudfeingprovider.controller;

import com.gupao.springcloudfeignapi.pojo.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PersonController {

    @PostMapping("/person/save")
    boolean save(@RequestBody Person person){
        System.out.println("remote request ok !");
        return new HashMap<>().put(person.getId(),person)==null;
    }
}
