package com.example.TicketChain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TicketChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketChainApplication.class, args);
	}

}
