package com.edu.HotelReservation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.HotelReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Query("select e from Reservation e where e.reservationDateAndTime = :reservationDateAndTime")
	List<Reservation> getReservationListByDateAndTime(@Param("reservationDateAndTime")LocalDateTime reservationDateTime);

//	List<Reservation> getReservationListByDateAndTime(LocalDateTime reservationDateAndTime);
	
//	@Query("select e from Reservation e where e.reservationDateAndTime = :reservationDateAndTime")
//	Optional<Reservation> getReservationByResrvationDateAndTime(@Param("reservationDateAndTime")String reservationDateAndTime);
//	List<Reservation> getReservationListByDate(LocalDateTime reservationDateTime);
	
}
