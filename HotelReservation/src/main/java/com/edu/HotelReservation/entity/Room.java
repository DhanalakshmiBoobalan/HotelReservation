package com.edu.HotelReservation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name="roomTbl",
uniqueConstraints = {@UniqueConstraint(columnNames = {"roomNo"})})

public class Room {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq", initialValue = 101)
	
	private long roomId;
	@Column(nullable = false, unique = true)
	private long roomNo;
	@Column(nullable = false)
	@Range(min=1,max=3,message="Allows only 3 beds in a Room")
	private String noOfBed;
	private double roomFare;
	private boolean status;
	
	@OneToOne(mappedBy="room", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("room")
	private Reservation reservation;
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}
	public String getNoOfBed() {
		return noOfBed;
	}
	public void setNoOfBed(String noOfBed) {
		this.noOfBed = noOfBed;
	}
	public double getRoomFare() {
		return roomFare;
	}
	public void setRoomFare(double roomFare) {
		this.roomFare = roomFare;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Room(long roomId, long roomNo, String noOfBed, double roomFare, boolean status) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.noOfBed = noOfBed;
		this.roomFare = roomFare;
		this.status = status;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNo=" + roomNo + ", noOfBed=" + noOfBed + ", roomFare=" + roomFare
				+ ", status=" + status + "]";
	}

}
