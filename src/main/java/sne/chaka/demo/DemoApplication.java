package sne.chaka.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import sne.chaka.demo.domain.User;
import sne.chaka.demo.domain.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx, UserRepository userRepository) {
		return args -> {

			// Beans list
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			log.info("Let's inspect the beans provided by Spring Boot:");
			log.info("-------------------------------");
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

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

		};
	}

}
