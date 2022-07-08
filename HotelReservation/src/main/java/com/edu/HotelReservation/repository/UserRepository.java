package com.edu.HotelReservation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.HotelReservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> getUserByFirstName(String firstName);

//	List<User> getUserByLastName(String lastName);

//	List<User> getUserByFullName(String firstName, String lastName);

	Optional<User> getUserByEmailId(String emailId);
	
//	@Query("select u from User u where u.firstName = :firstName")
//	List<User> getUserByFirstName(@Param("firstName")String firstName);
	
	@Query("select u from User u where u.lastName = :lastName")
	List<User> getUserByLastName(@Param("lastName")String lastName);
	
	@Query("select u from User u where u.firstName = :firstName and u.lastName = :lastName")
	List<User> getUserByFullName(@Param("firstName")String firstName, @Param("lastName")String lastName);

//	Optional<User> findUserByEmailId(String string);

	
/*	Optional<User> findByEmailId(String emailId);
	Optional<User> findByUserName(String userName);
	Optional<User> findByAadharNumber(String string); */


}
