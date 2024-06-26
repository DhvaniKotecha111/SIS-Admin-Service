package com.opl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@CrossOrigin()
@EnableDiscoveryClient
public class ServiceAdministratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAdministratorApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
