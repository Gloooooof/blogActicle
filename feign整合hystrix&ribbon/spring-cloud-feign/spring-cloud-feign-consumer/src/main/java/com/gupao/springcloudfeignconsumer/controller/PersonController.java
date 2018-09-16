package com.gupao.springcloudfeignconsumer.controller;


import com.gupao.springcloudfeignconsumer.HelloServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Person;

@RestController
public class PersonController {

    @Autowired
    private HelloServiceFeign client;

    /**
     * @param name
     * @return Person
     * @Description: 测试服务提供者post接口
     * @create date 2018年5月19日上午9:44:08
     */
    @RequestMapping(value = "/client/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(String name) {
        return client.postPerson(name);
    }

    /**
     *
     * @return String
     * @Description: 测试服务提供者get接口
     * @create date 2018年5月19日上午9:46:34
     */
    @RequestMapping(value = "/client/getHost", method = RequestMethod.GET)
    public String getHost() {
        return client.getHost();
    }
}
