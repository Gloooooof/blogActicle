package com.gupao.springcloudfeignconsumer.fallback;

import com.gupao.springcloudfeignconsumer.HelloServiceFeign;
import pojo.Person;

public class HelloFackback implements HelloServiceFeign {
    @Override
    public String getHost() {
        return "fail";
    }

    @Override
    public Person postPerson(String name) {
        return null;
    }
}
