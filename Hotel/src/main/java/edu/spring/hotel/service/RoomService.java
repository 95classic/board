package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.RoomVO;

public interface RoomService {
	List<RoomVO> read(int hotelId);
	RoomVO selectRead(int roomId);
} // end RoomService
