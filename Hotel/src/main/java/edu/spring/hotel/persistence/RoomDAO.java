package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.RoomVO;

public interface RoomDAO {
	
	// 그 호텔의 방 목록 전체검색
	List<RoomVO> selectByHotelId(int hotelId);
	
	// 방 상세검색
	RoomVO select(int roomId);
	
	// 예약 등록, 취소가 일어날 때 잔여 객실 수 수정
	int updateRoomCnt(int amount, int roomId);
	
} // end RoomDAO
