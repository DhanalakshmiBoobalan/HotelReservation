package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.edu.HotelReservation.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getUserList();

	User getUserById(long id);

	User updateUser(long id, User user);

	String deleteUser(long id);

	List<User> getUserByFirstName(String firstName);

	List<User> getUserByLastName(String lastName);

	List<User> getUserByFullName(String firstName, String lastName);

	User getUserByEmailId(String emailId);

//	User addUser(@Valid User user);

//	User getUserByEmailId(String emailId); */
	 
}
