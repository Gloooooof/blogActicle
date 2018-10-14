package com.gupao.springcloudserverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableConfigServer
@EnableScheduling
@EnableDiscoveryClient
public class SpringCloudServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerConfigApplication.class, args);
	}
	@Scheduled(fixedRate=1000)
	public  void test(){
		System.out.println("测试 : "+Thread.currentThread().getName());
	}
}
