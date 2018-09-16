package com.gupao.springcloudfeignconsumer;

import com.gupao.springcloudfeignconsumer.fallback.HelloFackback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Person;


@FeignClient(value = "person-provider",fallback = HelloFackback.class)
public interface HelloServiceFeign {

    @RequestMapping(value = "/demo/getHost", method = RequestMethod.GET)
     String getHost();

    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    Person postPerson(String name);
}
