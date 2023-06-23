package edu.spring.hotel.persistence;

import edu.spring.hotel.domain.HeartVO;

public interface HeartDAO {

	int select(int hotelId, String memberId); // 좋아요 상태 판별 검색
	
	int insert(HeartVO vo); // 좋아요 등록
	
	int delete(int hotelId, String memberId); // 좋아요 삭제
	
	int selectHeartCnt(String memberId); // 내가 좋아요 한 개수 검색
	
}
