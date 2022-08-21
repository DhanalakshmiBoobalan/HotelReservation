package com.edu.HotelReservation.RepositoryTest;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.repository.RoomRepository;

@DataJpaTest
@AutoConfigureTestDatabase (replace = Replace.NONE)
@Rollback(false)

public class RoomRepositoryTest {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void saveRoomTest() {
		Room room = roomRepository.save(new Room(155,138,"3",500.00,true));
		Assertions.assertThat(room.getRoomId()).isGreaterThan(0);
		// if id is greater than 0
	}
	
	@Test
	public void getRoomTest() {
		Room room = roomRepository.findById(101L).get();
		Assertions.assertThat(room.getRoomId()).isEqualTo(101L);
	}
	
	@Test
	public void getRoomListTest() {
		List<Room> rooms = roomRepository.findAll();
		Assertions.assertThat(rooms.size()).isGreaterThan(0);
	}
	
/*	@Test
	public void updateRoomTest() {
		Room room = roomRepository.findById(101L).get();
		room.setRoomNo("139");
		Room updated = roomRepository.save(room);
		Assertions.assertThat(updated.getRoomId().isEqualTo("139"));
	} */
	
	@Test
	public void deleteRoomTest() {
		Room rooms = roomRepository.findById(101L).get();
		roomRepository.delete(rooms);
		//101
		Room room = null;
		Optional<Room> room1 = roomRepository.getRoomByRoomNo("139");
		if(room1.isPresent()) {
			room = room1.get();
		}
	}

}