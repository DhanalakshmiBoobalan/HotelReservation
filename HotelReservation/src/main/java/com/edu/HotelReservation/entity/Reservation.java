package com.edu.HotelReservation.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservationTbl")
//@Data
//@EqualsAndHashCode(exclude = "users")

public class Reservation {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq", initialValue = 1001)
	
	private long resId;
	@Column(nullable = false)
	
	private int noOfGuest;
	private LocalDateTime reservationDateAndTime;
	private int noOfDays;
	private LocalDateTime checkInDateTime;
	private LocalDateTime checkOutDateTime;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties("reservation")
	private User user;
	
	@OneToOne
	@JoinColumn(name="roomId")
	@JsonIgnoreProperties("reservation")
	private Room room;
	
	@PrePersist
	public void addCheckInDate()
	{
		LocalDateTime now = LocalDateTime.now();
		this.reservationDateAndTime=now;
		this.checkOutDateTime = ((LocalDateTime) this.checkInDateTime).plusDays(noOfDays);
	}

	public long getResId() {
		return resId;
	}

	public void setResId(long resId) {
		this.resId = resId;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public LocalDateTime getReservationDateAndTime() {
		return reservationDateAndTime;
	}

	public void setReservationDateAndTime(LocalDateTime reservationDateAndTime) {
		this.reservationDateAndTime = reservationDateAndTime;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public LocalDateTime getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(LocalDateTime checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public LocalDateTime getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Reservation(long resId, int noOfGuest, LocalDateTime reservationDateAndTime, int noOfDays,
			LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, User user, Room room) {
		super();
		this.resId = resId;
		this.noOfGuest = noOfGuest;
		this.reservationDateAndTime = reservationDateAndTime;
		this.noOfDays = noOfDays;
		this.checkInDateTime = checkInDateTime;
		this.checkOutDateTime = checkOutDateTime;
		this.user = user;
		this.room = room;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservation [resId=" + resId + ", noOfGuest=" + noOfGuest + ", reservationDateAndTime="
				+ reservationDateAndTime + ", noOfDays=" + noOfDays + ", checkInDateTime=" + checkInDateTime
				+ ", checkOutDateTime=" + checkOutDateTime + ", user=" + user + ", room=" + room + "]";
	}
	

}
