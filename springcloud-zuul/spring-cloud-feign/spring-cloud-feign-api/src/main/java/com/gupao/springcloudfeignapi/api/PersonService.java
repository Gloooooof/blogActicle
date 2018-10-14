package com.gupao.springcloudfeignapi.api;

import com.gupao.springcloudfeignapi.pojo.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("person-provider")
public interface PersonService {

    @PostMapping("/person/save")
    boolean save(@RequestBody Person person);
}
