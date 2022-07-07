package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<Room> getRoomList() {
		List<Room> rooms = roomRepository.findAll();
		if(rooms.isEmpty()) {
			throw new NoRecordFoundException();
		}
		else {
			return rooms;
		}
	}

	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(long roomId) {
		Optional<Room> room = roomRepository.findById(roomId);
		if(room.isPresent()) {
			return room.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Room updateRoom(long roomId, Room room) {
		
		Room rooms = new Room();
		rooms = roomRepository.findById(roomId).orElseThrow(
				()-> new NoRecordFoundException());
		
		rooms.setRoomNo(room.getRoomNo());
		rooms.setNoOfBed(room.getNoOfBed());
		rooms.setRoomFare(room.getRoomFare());
		rooms.setStatus(room.getStatus());	
		
		roomRepository.save(rooms);
		
		//ResourceNotFoundException("Room", "")
		return rooms;
	} 

	@Override
	public String deleteRoom(long roomId) {
		Room room = new Room();
		room = roomRepository.findById(roomId).orElseThrow(()-> new NoRecordFoundException());
		roomRepository.deleteById(roomId);
		return "Record is Deleted Sucessfully";
	}

	@Override
	public Room getRoomByRoomNo(long roomNo) {
		Optional<Room> room = roomRepository.findByRoomNo(roomNo);
		if(room.isPresent()) {
			return room.get();
		}
		else {
			throw new NoRecordFoundException();
		}
	}

	@Override
	public Room getRoomByNoOfBed(String noOfBed) {
		Optional<Room> room = roomRepository.findByNoOfBed(noOfBed);
		if(room.isPresent()) {
			return room.get();
		}
		else {
			throw new NoRecordFoundException();
		}
	}



}
