package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReservationVO;

public interface ReservationDAO {
	// 예약 등록
	int insert(ReservationVO vo);
	// 내 예약 목록 검색
	List<ReservationVO> select(String memberId);
	// 예약 삭제
	int delete(int reservationId, int roomId);
	
} // end ReservationDAO
