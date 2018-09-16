package com.gupao.springcloudrurekaserverfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudRurekaServerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRurekaServerFeignApplication.class, args);
	}
}
