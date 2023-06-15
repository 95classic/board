package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.persistence.HotelDAO;

@Service 

public class HotelServiceImple implements HotelService{
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelServiceImple.class);
	
	@Autowired
	private HotelDAO dao;

	@Override
	public HotelVO read(int hotelId) {
		logger.info("read()호출 hotelId = " + hotelId);
		return dao.select(hotelId);
	} // end read 호텔 상세 검색 

	@Override
	public List<HotelVO> read(PageCriteria criteria) {
		logger.info("read()호출");
		return dao.selectAllByDefault(criteria);
	} // end read 전체 검색 기본 

	@Override
	public List<HotelVO> readOrderByReviewDesc(PageCriteria criteria) {
		logger.info("readOrederByReviewDesc()호출");
		return dao.selectAllByReviewDesc(criteria);
	} // end readOrderByReviewDesc 리뷰순 전체 검색

	@Override
	public List<HotelVO> readOrderByStarAvgDesc(PageCriteria criteria) {
		logger.info("readOrederByStarAvgDesc()호출");
		return dao.selectAllByStarAvgDesc(criteria);
	} // end readOrederByStarAvgDesc 별점순 전체 검색

	@Override
	public List<HotelVO> readOrderByHotelNameDesc(PageCriteria criteria) {
		logger.info("readOrederByHotelNameDesc()호출");
		return dao.selectAllByHotelNameDesc(criteria);
	} // end readOrderByHotelNameDesc 호텔 이름순 전체 검색

	@Override
	public List<HotelVO> readByHotelName(String keyword, PageCriteria criteria) {
		logger.info("readByHotelName()호출");
		return dao.selectByHotelName(keyword, criteria);
	} // end readHotelName 호텔 이름으로 검색

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()호출");
		return dao.getTotalCount();
	} // end getTotalCounts 전체 호텔 수 불러오기 

	


}
