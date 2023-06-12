package edu.spring.board.persistence;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;

public interface HotelDAO {
	
	HotelVO select(int hotelId); // 호텔 상세 검색
	
	List<HotelVO> selectAllByDefault(PageCriteria criteria); // 호텔 기본 전체 검색
	
	List<HotelVO> selectAllByReviewDesc(PageCriteria criteria); // 호텔 리뷰순 전체 검색
	
	List<HotelVO> selectAllByStarAvgDesc(PageCriteria criteria); // 호텔 평점순 전체 검색

	List<HotelVO> selectAllByHotelNameDesc(PageCriteria criteria); // 호텔 가나다순 전체 검색

	List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria); // 호텔 이름 키워드로 검색
	
	int getTotalCount(); // 전체 호텔 수 불러오기
	
	int updateReviewCntAndAvg(int amount, int hotelId); // 호텔 별점 등록, 삭제시 별점 평균 수정
	
	int updateHeartCnt(int amount, int hotelId); // 하트 등록, 삭제시 하트 카운트 수정
	
	List<HotelVO> selectByHeart(String memberId); // 사용자가 찜한 호텔목록 전체 검색 

}
