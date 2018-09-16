package com.gupao.springcloudfeignconsumer;

import com.gupao.springcloudfeignconsumer.fallback.HelloFackback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = HelloServiceFeign.class)
@EnableHystrix
public class SpringCloudFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignConsumerApplication.class, args);
	}
	@Bean
	public HelloFackback get(){
		return new HelloFackback();
	}
}
