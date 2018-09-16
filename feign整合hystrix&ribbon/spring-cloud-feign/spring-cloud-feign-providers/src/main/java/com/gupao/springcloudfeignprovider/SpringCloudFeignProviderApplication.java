package com.gupao.springcloudfeignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudFeignProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignProviderApplication.class, args);
	}
}
