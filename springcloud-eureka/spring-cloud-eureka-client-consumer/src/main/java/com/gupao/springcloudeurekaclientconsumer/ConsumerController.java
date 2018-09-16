package com.gupao.springcloudeurekaclientconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class ConsumerController {

    @Autowired
    public RestTemplate restTemplate;

    public static final Random random = new Random();

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return restTemplate.getForEntity("http://eureka.client.producer/producer/hello?name="+name,String.class).getBody();
    }

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod="fail",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
    public String hello() throws InterruptedException {
        int anInt = random.nextInt(200);
        System.out.println("随机数睡眠时间 : "+anInt);
        Thread.sleep(anInt);
        return "hello";
    }
    public String fail(){
        return "fail";
    }
}