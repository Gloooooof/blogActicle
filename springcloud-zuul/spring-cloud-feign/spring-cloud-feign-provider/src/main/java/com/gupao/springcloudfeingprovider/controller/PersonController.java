package com.gupao.springcloudfeingprovider.controller;

import com.gupao.springcloudfeignapi.pojo.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class PersonController {

    public Random random = new Random();

    @PostMapping("/person/save")
    @HystrixCommand(fallbackMethod="fallbackSave",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "100")
        }
    )
    boolean save(@RequestBody Person person) throws InterruptedException {
        System.out.println("remote request ok !");
        int i = random.nextInt(200);
        System.out.println("随机 : "+i);
        Thread.sleep(i);
        return new HashMap<>().put(person.getId(),person)==null;
    }
    boolean fallbackSave(Person person){
        System.err.println("request error");
        return false;
    }


}
