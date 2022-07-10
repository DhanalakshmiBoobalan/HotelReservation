package com.edu.HotelReservation.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.service.ReservationService;
import com.edu.HotelReservation.service.UserService;

@RestController
@RequestMapping("/api/reservation")

public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public List<Reservation> getReservationList(){
		return reservationService.getReservationList();
		
	}
	
	@GetMapping("/{resId}")
	public Reservation getReservationById(@PathVariable("resId") long resId) {
		return reservationService.getReservationById(resId);
		
	}
	
	@PostMapping
	public ResponseEntity<Reservation> saveReservation(@Valid @RequestBody Reservation reservation){
		return new ResponseEntity<Reservation>(reservationService.saveReservation(reservation), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{resId}")
	public Reservation updateReservation(@PathVariable("resId") long resId, @RequestBody Reservation reservation){
		return reservationService.updateReservation(resId, reservation);
		
	}
	
	@DeleteMapping("/{resId}")
	public ResponseEntity<String> deleteReservation(@PathVariable("resId") long resId){
		return new ResponseEntity<String>(reservationService.deleteReservation(resId), HttpStatus.OK);
		
	}
	
	@GetMapping("/GetReservationByDateAndTime/{reservationDateAndTime}")
	public List<Reservation> getReservationListByDateAndTime(@PathVariable("reservationDateAndTime") LocalDateTime reservationDateAndTime)
	{
		System.out.println(reservationDateAndTime);
		return reservationService.getReservationListByDateAndTime(reservationDateAndTime);
	}

	
/*	@GetMapping("/GetReservationByDate/{reservationDateTime}")
	public List<Reservation> getReservationListByDate(@PathVariable("reservationDateTime") LocalDateTime reservationDateTime)
	{
		return reservationService.getReservationListByDate(reservationDateTime);
	} */

}
