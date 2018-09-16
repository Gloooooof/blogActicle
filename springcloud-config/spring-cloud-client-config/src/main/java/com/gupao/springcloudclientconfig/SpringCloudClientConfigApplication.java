package com.gupao.springcloudclientconfig;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringCloudClientConfigApplication {

	@Value("${my.name}")
	public String name;
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientConfigApplication.class, args);
	}

	@GetMapping("/config")
	public String getConfig(){
		return name;
	}
}
