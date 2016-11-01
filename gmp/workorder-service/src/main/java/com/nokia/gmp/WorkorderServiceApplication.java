package com.nokia.gmp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nokia.gmp.repository")
//@EnableRabbit
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTransactionManagement
public class WorkorderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkorderServiceApplication.class, args);
	}

}

