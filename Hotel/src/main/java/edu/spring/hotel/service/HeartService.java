package edu.spring.hotel.service;

import edu.spring.hotel.domain.HeartVO;

public interface HeartService {
	
	// 좋아요 상태 읽기
	int read(int hotelId, String memberId);
	
	// 좋아요 등록
	int create(HeartVO vo);
	
	// 좋아요 취소
	int delete(int hotelId, String memberId);
	
	
} // end HeartService
