package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReservationVO;

public interface ReservationService {
	int create(ReservationVO vo);
	List<ReservationVO> read(String memberId);
	int delete(int reservationId, int roomId);
	
} // end ReserVationService
