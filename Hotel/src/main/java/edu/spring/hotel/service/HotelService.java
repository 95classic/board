package edu.spring.hotel.service;

import java.util.List;


import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface HotelService {
	HotelVO read(int hotelId); // 상세 검색
	
	List<HotelVO> read(PageCriteria criteria); // 전체 검색 (페이징 처리)
	
	List<HotelVO> readOrderByReviewDesc(PageCriteria criteria); // 리뷰순 내림차순 전체 검색
	
	List<HotelVO> readOrderByReviewAvgDesc(PageCriteria criteria); // 평균 별점 내림차순 전체검색
	
	List<HotelVO> readOrderByHotelNameAsc(PageCriteria criteria); // 가나다 내림차순 전체검색
	
	List<HotelVO> readByHotelName(String keyword, int start, int end); // 호텔 이름 키워드로 검색
	
	int getTotalCounts(); //  전체 호텔 수 받아오기 
	
	int getTotalCountsByHotelName(String keyword); // 호텔명 검색에 따른 호텔 수 받아오기
	
	List<HotelVO> readByHeart(String memberId); // 내가 찜한 호텔 목록 조회


} // end HotelService
