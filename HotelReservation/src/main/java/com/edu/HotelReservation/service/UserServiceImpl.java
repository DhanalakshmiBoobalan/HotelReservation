package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NameNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.RecordAlreadyExistException;
import com.edu.HotelReservation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		Optional<User> users = userRepository.findById(user.getUserId());
		if(!users.isPresent())
			return userRepository.save(user);
		else
			throw new RecordAlreadyExistException();
		
//		return userRepository.save(user);
	}

	@Override
	public List<User> getUserList() {
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
			throw new NoRecordFoundException();
		else
			return users;
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	} 

	@Override
	public User updateUser(long userId, User user) {
		
		User users = new User();
		users = userRepository.findById(userId).orElseThrow(()-> new NoRecordFoundException());
				
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setContactNo(user.getContactNo());
		users.setAadharNo(user.getAadharNo());
		users.setUserName(user.getUserName());
		users.setPassword(user.getPassword());
		users.setEmailId(user.getEmailId());
		users.setFullAddress(user.getFullAddress());
		
		userRepository.save(users);
		return users;
	} 

	@Override
	public String deleteUser(long userId) {
		User user = new User();
		user = userRepository.findById(userId).orElseThrow(()-> new NoRecordFoundException());
		userRepository.deleteById(userId);
		return "Record is Deleted Sucessfully";
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.getUserByFirstName(firstName);
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		List<User> user = userRepository.getUserByLastName(lastName);
		if(user.isEmpty())
		{
			throw new NameNotFoundException();
		}
		else
		{
			return user;
		}
//		return userRepository.getUserByLastName(lastName);
	}

	@Override
	public List<User> getUserByFullName(String firstName, String lastName) {
		return userRepository.getUserByFullName(firstName, lastName);
	}


	@Override
	public Optional<User> getUserByEmailId(String emailId) {
		return userRepository.getUserByEmailId(emailId);
	}
	
/*	@Override
	public User getUserByEmailId(String emailId) {
		return userRepository.getUserByEmailId(emailId);
	} */



}
