package com.edu.HotelReservation.controller;

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

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.service.RoomService;
import com.edu.HotelReservation.service.UserService;

@RestController
@RequestMapping("/api/room")

public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping
	public List<Room> getRoomList(){
		return roomService.getRoomList();
		
	}
	
	@GetMapping("/{roomId}")
	public Room getRoomById(@PathVariable("roomId") long roomId) {
		return roomService.getRoomById(roomId);
		
	}
	
	@PostMapping
	public ResponseEntity<Room> saveRoom(@Valid @RequestBody Room room){
		return new ResponseEntity<Room>(roomService.saveRoom(room), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{roomId}")
	public Room updateRoom(@PathVariable("roomId") long roomId, @Valid @RequestBody Room room) {
		return roomService.updateRoom(roomId, room);
		
	}
	
	@DeleteMapping("/{roomId}")
	public ResponseEntity<String> deleteRoom(@PathVariable("roomId") long roomId){
		return new ResponseEntity<String> (roomService.deleteRoom(roomId), HttpStatus.OK);
		
	}
	
	@GetMapping("/GetByRoomNo/{roomNo}")
	public Room getRoomByRoomNo(@PathVariable("roomNo") long roomNo) {
		return roomService.getRoomByRoomNo(roomNo);
		
	}
	
	@GetMapping("/GetByNoOfBed/{noOfBed}")
	public Room getRoomByNoOfBed(@PathVariable("noOfBed") String noOfBed) {
		return roomService.getRoomByNoOfBed(noOfBed);
		
	}

}