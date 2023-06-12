package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface HotelService {
	HotelVO read(int hotelId); // 상세 검색

	List<HotelVO> read(PageCriteria criteria); // 전체 검색
	
	List<HotelVO> readOrderByReviewDesc(PageCriteria criteria); // 리뷰 내림차순 전체 검색
	
	List<HotelVO> readOrderByStarAvgDesc(PageCriteria criteria); // 평균 별점 내림차순 전체 검색
	
	List<HotelVO> readOrderByHotelNameDesc(PageCriteria criteria); // 가나나 내림차순 전체검색
	
	List<HotelVO> readByHotelName(String keyword, PageCriteria criteria); // 호텔 이름으로 검색
	
	int getTotalCounts(); // 전체 호텔 수 받아오기 
	
	List<HotelVO> readByHeart(String memberId); // 내가 찜한 호텔 목록 조회
	
} // end HotelService
