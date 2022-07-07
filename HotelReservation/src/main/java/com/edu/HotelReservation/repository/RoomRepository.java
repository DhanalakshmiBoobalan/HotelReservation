package com.edu.HotelReservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.HotelReservation.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	Optional<Room> findByRoomNo(long roomNo);

	Optional<Room> findByNoOfBed(String noOfBed);
	
/*	@Query("select r from Room r where r.roomNo = :roomNo")
	Optional<Room> getRoomByRoomNo(@Param("roomNo")String roomNo);
	
	@Query("select r from Room r where r.noOfBed = :noOfBed")
	List<Room> getRoomByNoOfBed(@Param("noOfBed")String noOfBed); */
	
//	List<Room> findByStatus(boolean status);
//	Optional<Room> findByRoomFare(double d);


}
