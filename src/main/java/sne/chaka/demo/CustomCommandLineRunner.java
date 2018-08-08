package sne.chaka.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import sne.chaka.demo.domain.User;
import sne.chaka.demo.domain.repository.UserRepository;

/**
 * Interface dansspring boot qui permet d'executer des instructions lorsque
 * l'application démarre
 * 
 * @author citizendiop
 *
 */
@Component
@Log
public class CustomCommandLineRunner implements CommandLineRunner {

	private UserRepository userRepository;

	public CustomCommandLineRunner(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// Test Spring data japa

		// save a couple of customers
		userRepository.save(new User("Jack", "Bauer"));
		userRepository.save(new User("Chloe", "O'Brian"));
		userRepository.save(new User("Kim", "Bauer"));
		userRepository.save(new User("David", "Palmer"));
		userRepository.save(new User("Michelle", "Dessler"));

		// fetch all customers
		log.info("User found with findAll():");
		log.info("-------------------------------");
		userRepository.findAll().forEach(u -> log.info(u.toString()));
		log.info("");

		// fetch an individual customer by ID
		userRepository.findById(1L).ifPresent(customer -> {
			log.info("User found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
		});

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		userRepository.findByLastName("Bauer").forEach(u -> log.info(u.toString()));
		log.info("");
	}

}
