package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReviewVO;

public interface ReviewService {
	// 리뷰 작성
	int create(ReviewVO vo);
	// 리뷰 읽기
	List<ReviewVO> read(int hotelId);
	// 리뷰 수정
	int update(ReviewVO vo);
	// 리뷰 삭제
	int delete(int reviewId, int hotelId) throws Exception;
	
} // end ReviewService
