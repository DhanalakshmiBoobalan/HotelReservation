package com.edu.HotelReservation.RepositoryTest;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase (replace = Replace.NONE)
@Rollback(false)

public class UserRepositoyTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void saveUserTest() {
		User user = userRepository.save(new User(12,"Priya","Boobalan","3456789345","123456798765","Priya","56784","priya@gmail.com","Mumbai"));
		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
	}
	
/*	@Test
	public void saveUserTest() {  ///test case
		User user = userRepository.save(new User(11,"Dhana","Lakshmi","9841509185","567899012344","Dhana","12345","abc@gmail.com","Chennai"));
		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
		// if id is greater than 0
	} */
	
	@Test
	public void getUserTest() {
		User user = userRepository.findById(11L).get();
		Assertions.assertThat(user.getUserId()).isEqualTo(11L);
	}
	
	@Test
	public void getUserListTest() {
		List<User> users = userRepository.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateUserTest() {
		User user = userRepository.findById(462L).get();
		user.setEmailId("hij@gmail.com");
		User updated = userRepository.save(user);
		Assertions.assertThat(updated.getEmailId()).isEqualTo("hij@gmail.com");
	}
	
	@Test
	public void deleteUserTest() {
		User use = userRepository.findById(462L).get();
		userRepository.delete(use);
		//462
		User user = null;
		Optional<User> use1 = userRepository.getUserByEmailId("hij@gmail.com");
		if(use1.isPresent()) {
			user = use1.get(); //null
		}
		
		Assertions.assertThat(user).isNull();
		
	}

}