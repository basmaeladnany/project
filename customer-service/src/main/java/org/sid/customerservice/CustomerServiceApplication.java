package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner comm(CustomerRepository customerRepository){
		return args -> {
			//saveall pour enregistrer une liste
			customerRepository.saveAll(List.of(
					Customer.builder().name("basma").email("basma@gmail.com").build(),
					Customer.builder().name("aymen").email("aymen@gmail.com").build(),
					Customer.builder().name("driss").email("driss@gmail.com").build()

			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
