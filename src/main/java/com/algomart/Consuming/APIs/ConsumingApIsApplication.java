package com.algomart.Consuming.APIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.algomart.Consuming.APIs")
@ComponentScan(basePackages = "com.algomart.Consuming.APIs")
public class ConsumingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApIsApplication.class, args);
	}

}
