package com.edu.HotelReservation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
	UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
/*	@PostMapping
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	} */
	
	@GetMapping
	public List<User> getUserList() {
		return userService.getUserList();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") long userId) { //101
		return userService.getUserById(userId);
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId") long userId, @Valid @RequestBody User user) {
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") long userId){
		return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);		
	}
	
	@GetMapping("/GetByFirstName/{firstName}")
	public List<User> getUserByFirstName(@PathVariable("firstName") String firstName)
	{
		return userService.getUserByFirstName(firstName);
		
	}
	
	@GetMapping("/GetByLastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable("lastName") String lastName)
	{
		return userService.getUserByLastName(lastName);
		
	}
	
	@GetMapping("/GetByFullName/{firstName}/{lastName}")
	public List<User> getUserByFullName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName)
	{
		return userService.getUserByFullName(firstName, lastName);
		
	}
	
	@GetMapping("GetByEmailId/{emailId}")
	public Optional<User> getUserByEmailId(@PathVariable("emailId") String emailId)
	{
		return userService.getUserByEmailId(emailId);
	}

}
