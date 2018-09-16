package com.gupao.springcloudhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
//@EnableHystrix
@RestController
@EnableCircuitBreaker
public class SpringCloudHystrixApplication {
	public static final Random random = new Random();
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixApplication.class, args);
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
