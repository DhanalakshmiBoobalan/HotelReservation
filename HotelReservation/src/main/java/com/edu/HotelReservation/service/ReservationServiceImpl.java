package com.edu.HotelReservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> getReservationList() {
		List<Reservation> reserv = reservationRepository.findAll();
		if(reserv.isEmpty())
			throw new NoRecordFoundException();
		else
			return reserv;
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservationById(long resId) {
		Optional<Reservation> reserv = reservationRepository.findById(resId);
		if(reserv.isPresent()) {
			return reserv.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Reservation updateReservation(long resId, Reservation reservation) {
		Reservation reserv = new Reservation();
		reserv = reservationRepository.findById(resId).orElseThrow(()-> new NoRecordFoundException());
		
		reserv.setNoOfGuest(reservation.getNoOfGuest());
		reserv.setReservationDateAndTime(reservation.getReservationDateAndTime());
		reserv.setNoOfDays(reservation.getNoOfDays());
		reserv.setCheckInDateTime(reservation.getCheckInDateTime());
		reserv.setCheckOutDateTime(reservation.getCheckOutDateTime());
		
		reservationRepository.save(reserv);
		return reserv;
	}

	@Override
	public String deleteReservation(long id) {
		Reservation reservation = new Reservation();
		reservation = reservationRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
		reservationRepository.deleteById(id);
		return "Record id Deleted Sucessfully";
	}


	@Override
	public List<Reservation> getReservationListByDateAndTime(LocalDateTime reservationDateAndTime) {
		
		List<Reservation> reservation = reservationRepository.getReservationListByDateAndTime(reservationDateAndTime);
		if(reservation.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return reservation;
		}
	}
	
/*	@Override
	public List<Reservation> getReservationByReservationDateAndTime(LocalDateTime reservationDateTime) {
		List<Reservation> reservation = reservationRepository.getReservationByReservationDateAndTime(reservationDateTime);
		if(reservation.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return reservation;
		}
	} 

	@Override
	public List<Reservation> getReservationListByDate(LocalDateTime reservationDateTime) {
		
		List<Reservation> reservation = reservationRepository.getReservationListByDate(reservationDateTime);
		if(reservation.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return reservation;
		}
	} */

}
