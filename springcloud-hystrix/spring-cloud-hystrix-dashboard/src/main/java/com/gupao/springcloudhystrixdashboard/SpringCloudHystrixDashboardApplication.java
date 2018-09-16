package com.gupao.springcloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class SpringCloudHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixDashboardApplication.class, args);
	}
}
