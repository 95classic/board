package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;


public interface HotelDAO {
	
	
	HotelVO select(int hotelId); // 호텔 상세 검색
	
	List<HotelVO> select(PageCriteria criteria); // 호텔 페이징 처리를 위한 전체 검색
	
	List<HotelVO> selectAllByReviewDesc(PageCriteria criteria); // 호텔 리뷰 많은 순 전체검색
	
	List<HotelVO> selectAllByReviewAvgDesc(PageCriteria criteria); // 호텔 평균 별점 순 전체검색
	
	List<HotelVO> selectAllByHotelNameAsc(PageCriteria criteria); // 호텔 가나다 순 전체검색
	
	List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria); // 호텔 이름 키워드로 검색

	int getTotalCounts(); // 전체 호텔 수 불러오기

	int updateReviewCntAndAvg(int amount, int hotelId); // 호텔 별점 등록, 삭제시 별점 평균 수정
	
	int updateHeartCnt(int amount, int boardId); // 하트 등록, 삭제 시 호텔 테이블의 하트 개수 수정
	
	List<HotelVO> selectByHeart(String memberId); // 사용자가 찜한 호텔목록 전체검색
	
}
