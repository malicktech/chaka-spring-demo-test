package sne.chaka.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import sne.chaka.demo.domain.User;
import sne.chaka.demo.domain.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findByLastName() throws Exception {
		// given
		User savedUser = userRepository.save(new User("Stephan", "Nicolle", LocalDate.of(2000, Month.JANUARY, 1)));
		
		// when 
		Optional<User> retrievedUser = userRepository.findById(1L);
		
		// Then
		assertThat(retrievedUser.get().getId().equals(savedUser.getId()));
	}
}
