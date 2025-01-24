package com.algomart.Consuming.APIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApIsApplication.class, args);
	}

}
